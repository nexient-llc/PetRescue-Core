package com.systemsinmotion.petrescue.mail;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.petfinder.entity.AnimalType;
import org.petfinder.entity.PetfinderPetRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.systemsinmotion.petrescue.web.bean.AdoptionApplication;

@Component("emailManager")
@PropertySource("classpath:/shelter.properties")
public class MailManager {
	private static final Logger logger = Logger.getLogger(MailManager.class);

	private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	private static final String MAIL_SMTP_HOST = "mail.smtp.host";
	private static final String SUBJECT_FIRST_NAME = "[firstName]";
	private static final String SUBJECT_LAST_NAME = "[lastName]";
	private static final String SUBJECT_PET_NAME = "[petName]";

	@Value("${shelter.email.from}")
	private String from;

	@Value("${shelter.email.host}")
	private String host;

	@Value("${shelter.email.password}")
	private String password;

	@Value("#{'${shelter.email.recipients}'.split(';')}")
	private String[] shelterRecipients;

	@Value("#{'${shelter.email.dog.recipients}'.split(';')}")
	private String[] shelterDogRecipients;

	@Value("#{'${shelter.email.cat.recipients}'.split(';')}")
	private String[] shelterCatRecipients;

	@Value("#{'${admin.email.recipients}'.split(';')}")
	private String[] adminRecipients;

	@Value("${shelter.email.subject}")
	private String subject;

	@Value("${shelter.email.username}")
	private String username;

	@Value("${shelter.name.full}")
	private String sheltername;

	@Value("${shelter.name.abv}")
	private String shelterabv;

	@Autowired
	private VelocityEngine velocityEngine;

	protected void addRecipients(MimeMessage message, AdoptionApplication application, PetfinderPetRecord pet) throws MessagingException, AddressException {
		String[] recipients = {};
		if (StringUtils.hasText(application.getEmail()) && application.getEmail().equals(adminRecipients[0])) {
			recipients = new String[] {adminRecipients[0]};
		} else if (pet != null && pet.getAnimal() == AnimalType.CAT) {
			recipients = this.shelterCatRecipients;
		} else if (pet != null && pet.getAnimal() == AnimalType.DOG) {
			recipients = this.shelterDogRecipients;
		} else {
			recipients = this.shelterRecipients;
		}
		for (String recipient : recipients) {
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		}
	}

	protected void addSubject(MimeMessage message, AdoptionApplication application) throws MessagingException {
		String subject = this.subject;
		subject = subject.replace(SUBJECT_FIRST_NAME, application.getFirstName());
		subject = subject.replace(SUBJECT_LAST_NAME, application.getLastName());
		subject = subject.replace(SUBJECT_PET_NAME, application.getPetName());
		message.setSubject(subject);
	}

	protected Properties createMailProperties() {
		Properties props = System.getProperties();
		props.put(MAIL_SMTP_HOST, this.host);
		props.put(MAIL_SMTP_AUTH, "true");

		// Google Connection Info
		// props.put("mail.smtp.host", "smtp.gmail.com");
		// props.put("mail.smtp.port", "587");
		// props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.starttls.enable", "true");

		return props;
	}

	protected Session createSession(Properties props) {
		return Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailManager.this.username, MailManager.this.password);
			}
		});
	}

	String getFrom() {
		return this.from;
	}

	String getHost() {
		return this.host;
	}

	String getPassword() {
		return this.password;
	}

	String[] getShelterRecipients() {
		return this.shelterRecipients;
	}

	String[] getAdminRecipients() {
		return this.adminRecipients;
	}

	String getSubject() {
		return this.subject;
	}

	String getUsername() {
		return this.username;
	}

	@PostConstruct
	public void init() {
	}

	public void send(AdoptionApplication application, PetfinderPetRecord pet) throws MessagingException {
		logger.debug("Received application to be emailed.");

		Properties props = createMailProperties();
		Session session = createSession(props);

		MimeMessage message = new MimeMessage(session);
		addSubject(message, application);
		addRecipients(message, application, pet);
		message.setFrom(new InternetAddress(this.from));

		String type = "text/html";
		String text;
		try {
			text = getText(application, pet);
		} catch (VelocityException e) {
			text = toJson(application);
			type = "text/plain";
		}

		message.setContent(text, type);

		Transport.send(message);
	}

	protected String getText(AdoptionApplication application, PetfinderPetRecord pet) throws MessagingException {
		Map<String, Object> app = new HashMap<String, Object>();
		app.put("application", application);
		app.put("pet", pet);
		String text = new String();
		text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/com/systemsinmotion/petrescue/templates/adopt.vm", "UTF-8", app);

		return text;
	}

	public void send_error(Exception e, String path) {
		logger.debug("Error occured, sending message to the admin");

		Properties props = createMailProperties();
		Session session = createSession(props);

		MimeMessage message = new MimeMessage(session);
		try {
			setErrorMessageFields(e, path, message);
			Transport.send(message);
		} catch (Exception e2) {
			// There's nothing more to report at this level
			logger.debug("Error! Email failed to send. This may be the result of incorrect connection information in shelter.properties");
			logger.debug(e.toString());
		}
	}

	private void setErrorMessageFields(Exception e, String path, MimeMessage message) throws MessagingException, AddressException {
		Date time = Calendar.getInstance().getTime();
		message.setSubject("[" + this.shelterabv + "] Error Report " + time);
		for (String recipient : this.adminRecipients) {
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		}
		message.setFrom(new InternetAddress(this.from));

		String text = "Error occured on " + this.sheltername + " website when calling " + path;
		text += " at " + time;
		text += "\n\n" + ExceptionUtils.getStackTrace(e);

		message.setText(text);
	}

	void setFrom(String from) {
		this.from = from;
	}

	void setHost(String host) {
		this.host = host;
	}

	void setPassword(String password) {
		this.password = password;
	}

	void setShelterRecipients(String[] recipients) {
		this.shelterRecipients = recipients;
	}

	void setAdminRecipients(String[] recipients) {
		this.adminRecipients = recipients;
	}

	void setSubject(String subject) {
		this.subject = subject;
	}

	public String[] getShelterDogRecipients() {
		return shelterDogRecipients;
	}

	public void setShelterDogRecipients(String[] shelterDogRecipients) {
		this.shelterDogRecipients = shelterDogRecipients;
	}

	public String[] getShelterCatRecipients() {
		return shelterCatRecipients;
	}

	public void setShelterCatRecipients(String[] shelterCatRecipients) {
		this.shelterCatRecipients = shelterCatRecipients;
	}

	void setUsername(String username) {
		this.username = username;
	}

	private String toJson(AdoptionApplication application) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(application);
	}

}
