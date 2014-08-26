package com.systemsinmotion.petrescue.datamanager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.systemsinmotion.petrescue.data.RemoteIdentifierRepository;
import com.systemsinmotion.petrescue.entity.PetRecord;
import com.systemsinmotion.petrescue.entity.RemoteIdentifier;
import com.systemsinmotion.petrescue.entity.type.ApiType;

@Service("remoteIdentifierManager")
public class RemoteIdentifierManager {

	@Autowired
	RemoteIdentifierRepository remoteIdentifierRepository;

	@Bean
	public RemoteIdentifierManager remoteIdentifierService() {
		return new RemoteIdentifierManager();
	}

	public List<RemoteIdentifier> findAllRemoteIdentifiers() {
		return this.remoteIdentifierRepository.findAll();
	}

	public RemoteIdentifier findPetById(PetRecord pet) {
		return this.remoteIdentifierRepository.findByPet(pet);
	}

	public RemoteIdentifier findByRemoteId(String id) {
		return this.remoteIdentifierRepository.findByRemoteId(id);
	}

	public List<RemoteIdentifier> findAllByAPIType(ApiType api) {
		return this.remoteIdentifierRepository.findByApi(api);
	}

	public List<RemoteIdentifier> findLastUpdatedThatIsLessThan(Date date) {

		return this.remoteIdentifierRepository.findByLastUpdatedLessThan(date);
	}

	public List<RemoteIdentifier> findAllLastUpdatedThatIsAfter(Date date) {
		return this.remoteIdentifierRepository.findByLastUpdatedAfter(date);
	}

	public List<RemoteIdentifier> findAllLastUpdatedThatIsBefore(Date date) {
		return this.remoteIdentifierRepository.findByLastUpdatedBefore(date);
	}

}
