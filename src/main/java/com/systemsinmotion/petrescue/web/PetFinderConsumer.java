package com.systemsinmotion.petrescue.web;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.petfinder.entity.AnimalType;
import org.petfinder.entity.Petfinder;
import org.petfinder.entity.PetfinderAuthData;
import org.petfinder.entity.PetfinderBreedList;
import org.petfinder.entity.PetfinderPetRecord;
import org.petfinder.entity.PetfinderPetRecordList;
import org.petfinder.entity.PetfinderShelterRecord;
import org.petfinder.entity.PetfinderShelterRecordList;
import org.petfinder.web.service.Method;
import org.petfinder.web.service.QueryParam;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import com.systemsinmotion.util.Strings;

/**
 * Class to consume PetFinder services. PetFinder API documentation can be found
 * at http://www.petfinder.com/developers/api-docs
 * 
 * @author kskronek
 * 
 */
@Service("petFinderService")
public class PetFinderConsumer {

	private static PetfinderAuthData authData;

	private static final Logger logger = Logger.getLogger(PetFinderConsumer.class);

	private static final String PETFINDER_HOST = "http://api.petfinder.com/";

	private RestTemplate restTemplate = new RestTemplate();

	private String shelterApiKey;

	private String shelterApiSecret;

	public String shelterId;

	/**
	 * Method getAuthData is a private method to only get a new
	 * PetfinderAuthData if the original one was never instantiated or has
	 * expired or is about to expire.
	 * 
	 * @return PetfinderAuthData
	 */
	PetfinderAuthData authData() {
		/*
		 * subtracting some time to ensure token is still good by the time it is
		 * used
		 */
		final BigInteger now = BigInteger.valueOf(GregorianCalendar.getInstance().getTimeInMillis() - 500);
		if (authData == null || authData.getExpires().compareTo(now) < 1) {
			authData = authToken();
		}
		return authData;
	}

	/**
	 * Method authToken calls the PetFinder API to retrieve a new token. The
	 * token is contained within PetfinderAuthData and expires after an hour.
	 * 
	 * @return PetfinderAuthData
	 */
	public PetfinderAuthData authToken() {
		String queryAuthToken = "key=" + shelterApiKey;
		final String sig = signatureParam(queryAuthToken);
		final String url = Strings.concat(PETFINDER_HOST, Method.AUTH_TOKEN.value, queryAuthToken, sig);
		final Petfinder petfinder = restTemplate.getForObject(url, Petfinder.class);
		final PetfinderAuthData auth = petfinder.getAuth();
		logger.debug("authToken: " + auth.getToken());
		return auth;
	}

	/**
	 * Method breedList.
	 * 
	 * @param animal
	 *            String
	 * @return PetfinderBreedList
	 */
	public PetfinderBreedList breedList(String animal, String format) {
		Map<QueryParam, Object> params = new TreeMap<QueryParam, Object>();
		params.put(QueryParam.animal, animal);
		params.put(QueryParam.format, format);

		final Petfinder petfinder = executeQuery(Method.BREED_LIST, params);
		return petfinder.getBreeds();
	}

	String buildQuery(String token, Map<QueryParam, Object> params, boolean doEncode) {
		logger.debug("buildQuery()");

		StringBuilder sb = new StringBuilder();
		sb.append("key=").append(shelterApiKey);
		sb.append("&token=").append(token);
		if (params != null && !params.isEmpty()) {
			for (QueryParam key : params.keySet()) {
				final String value = String.valueOf(params.get(key));
				if (params.get(key) != null && Strings.hasText(value)) {
					final String param = doEncode ? encodeQueryParam(value) : value;
					sb.append("&").append(key).append("=").append(param);
				}
			}
		}

		final String encodedUrl = sb.toString();
		logger.debug("encodedUrl(): encodedUrl: " + encodedUrl);
		return encodedUrl;
	}

	private Integer defaultCount(Integer count) {
		if (count == null) {
			count = 999;
		}
		return count;
	}

	private String encodeQueryParam(String url) {
		try {
			return UriUtils.encodeQueryParam(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	private Petfinder executeQuery(Method method, Map<QueryParam, Object> params) {
		final String token = this.authData().getToken();
		final String query = buildQuery(token, params, false);
		final String sig = signatureParam(buildQuery(token, params, true));
		final String url = Strings.concat(PETFINDER_HOST, method.value, query, sig);
		logger.debug("executeQuery(): url: " + url);
		return restTemplate.getForObject(url, Petfinder.class);
	}

	public PetfinderPetRecordList findPet(String animal, String breed, String size, Character sex, String location,
			String age, Integer offset, Integer count, String output, String format) {
		Map<QueryParam, Object> params = new TreeMap<QueryParam, Object>();
		params.put(QueryParam.animal, animal);
		params.put(QueryParam.breed, breed);
		params.put(QueryParam.size, size);
		params.put(QueryParam.sex, sex);
		params.put(QueryParam.location, location);
		params.put(QueryParam.age, age);
		params.put(QueryParam.offset, offset);
		params.put(QueryParam.count, count);
		params.put(QueryParam.output, output);
		params.put(QueryParam.format, format);

		final Petfinder petfinder = executeQuery(Method.FIND_PET, params);
		final PetfinderPetRecordList pets = petfinder.getPets();

		logger.debug("petRecordList : " + pets);
		return pets;
	}

	public PetfinderShelterRecordList findShelter(String location, String name, Integer offset, Integer count,
			String format) {
		Map<QueryParam, Object> params = new TreeMap<QueryParam, Object>();
		params.put(QueryParam.location, location);
		params.put(QueryParam.name, name);
		params.put(QueryParam.offset, offset);
		params.put(QueryParam.count, count);
		params.put(QueryParam.format, format);

		final Petfinder petfinder = executeQuery(Method.FIND_SHELTER, params);
		return petfinder.getShelters();
	}

	@PostConstruct
	public void init() {
		Configuration config;
		try {
			config = new PropertiesConfiguration("shelter.properties");
			this.shelterId = config.getString("shelter.id");
			this.shelterApiKey = config.getString("shelter.api.key");
			this.shelterApiSecret = config.getString("shelter.api.secret");
		} catch (ConfigurationException e) {
			logger.error("File shelter.properties must exist in the classpath.");
			throw new RuntimeException(e);
		}
	}

	public PetfinderPetRecord randomPet(String animal, String breed, String size, Character sex, String location,
			String shelterId, String output, String format) {
		Map<QueryParam, Object> params = new TreeMap<QueryParam, Object>();
		params.put(QueryParam.animal, animal);
		params.put(QueryParam.breed, breed);
		params.put(QueryParam.size, size);
		params.put(QueryParam.sex, sex);
		params.put(QueryParam.location, location);
		params.put(QueryParam.shelterid, shelterId);
		params.put(QueryParam.output, output);
		params.put(QueryParam.format, format);

		final Petfinder petfinder = executeQuery(Method.RANDOM_PET, params);
		return petfinder.getPet();
	}

	public PetfinderPetRecord readPet(BigInteger animalId, String format) {
		Map<QueryParam, Object> params = new TreeMap<QueryParam, Object>();
		params.put(QueryParam.id, animalId);
		params.put(QueryParam.format, format);

		final Petfinder petfinder = executeQuery(Method.GET_PET, params);
		final PetfinderPetRecord pet = petfinder.getPet();

		logger.debug("pet : " + pet);

		return pet;
	}

	public PetfinderShelterRecord readShelter(String format) {
		Map<QueryParam, Object> params = new TreeMap<QueryParam, Object>();
		params.put(QueryParam.id, shelterId);
		params.put(QueryParam.format, format);

		final Petfinder petfinder = executeQuery(Method.GET_SHELTER, params);
		return petfinder.getShelter();
	}

	public List<PetfinderPetRecord> shelterCats(Character status, Integer offset, Integer count, String output,
			String format) {
		final List<PetfinderPetRecord> pets = this.shelterPets(status, offset, count, output, format);
		List<PetfinderPetRecord> cats = new ArrayList<PetfinderPetRecord>();
		for (PetfinderPetRecord pet : pets) {
			if (pet.getAnimal().equals(AnimalType.CAT)) {
				cats.add(pet);
			}
		}
		return cats;
	}

	public List<PetfinderPetRecord> shelterDogs(Character status, Integer offset, Integer count, String output,
			String format) {
		final List<PetfinderPetRecord> pets = this.shelterPets(status, offset, count, output, format);
		List<PetfinderPetRecord> dogs = new ArrayList<PetfinderPetRecord>();
		for (PetfinderPetRecord pet : pets) {
			if (pet.getAnimal().equals(AnimalType.DOG)) {
				dogs.add(pet);
			}
		}
		return dogs;
	}

	public List<PetfinderPetRecord> shelterPets(Character status, Integer offset, Integer count, String output,
			String format) {

		List<PetfinderPetRecord> pets = null;// cacheWrapper.get("pets");
		if (pets == null) {
			Map<QueryParam, Object> params = new TreeMap<QueryParam, Object>();
			params.put(QueryParam.id, shelterId);
			params.put(QueryParam.status, status);
			params.put(QueryParam.offset, offset);
			params.put(QueryParam.count, defaultCount(count));
			params.put(QueryParam.output, output);

			final Petfinder petfinder = executeQuery(Method.SHELTER_PETS, params);
			PetfinderPetRecordList petRecordList = petfinder.getPets();
			pets = petRecordList.getPet();
			// cacheWrapper.put("pets", pets);
		}
		return pets;
	}

	public PetfinderShelterRecordList shelterPetsByBreed(String animal, String breed, Integer offset, Integer count,
			String format) {
		Map<QueryParam, Object> params = new TreeMap<QueryParam, Object>();
		params.put(QueryParam.animal, animal);
		params.put(QueryParam.breed, breed);
		params.put(QueryParam.offset, offset);
		params.put(QueryParam.count, count);
		params.put(QueryParam.format, format);

		final Petfinder petfinder = executeQuery(Method.SHELTER_PETS_BY_BREED, params);
		return petfinder.getShelters();
	}

	/**
	 * Method generateSignature generates a MD5 hash of the query string. The
	 * generated hash is appended to the query string as
	 * "&sig={generatedMD5Signature}".
	 * 
	 * @param query
	 *            String
	 * @param params
	 *            String[]
	 * @return String the generated MD5 hash as a hex string
	 */
	private String signatureParam(String query) {
		logger.debug("generateSignature(): query parameter: " + query);

		StringBuilder sb = new StringBuilder();
		sb.append(shelterApiSecret).append(query);
		final String secretQuery = sb.toString();
		logger.debug("generateSignature(): query to be encoded: " + secretQuery);

		final String md5DigestAsHex = DigestUtils.md5DigestAsHex(secretQuery.getBytes());
		logger.debug("generateSignature(): md5: " + md5DigestAsHex);

		return "&sig=" + md5DigestAsHex;
	}

}
