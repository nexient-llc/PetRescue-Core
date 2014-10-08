package com.systemsinmotion.petrescue.mail;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

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

	@Value("#{'${admin.email.recipients}'.split(';')}")
	private String[] adminRecipients;
	@Value("${adoption.email.from}")
	private String adoptionFrom;

	@Value("${adoption.email.subject}")
	private String adoptionSubject;

	@Value("${exception.email.from}")
	private String exceptionFrom;

	@Value("${exception.email.subject}")
	private String exceptionSubject;

	@Value("${admin.email.host}")
	private String host;

	private Properties mailProperties;

	private Session mailSession;

	@Value("${admin.email.password}")
	private String password;

	@Value("#{'${adoption.email.cat.recipients}'.split(';')}")
	private String[] shelterCatRecipients;

	@Value("#{'${adoption.email.dog.recipients}'.split(';')}")
	private String[] shelterDogRecipients;

	@Value("${shelter.name.full}")
	private String shelterNameFull;

	@Value("${shelter.name.short}")
	private String shelterNameShort;

	@Value("${admin.email.username}")
	private String username;

	@Autowired
	private VelocityEngine velocityEngine;

	@PostConstruct
	private void init() {
		this.mailProperties = createMailProperties();
		this.mailSession = createMailSession();
	}

	public void sendAdoptionApplication(AdoptionApplication application, PetfinderPetRecord pet)
			throws MessagingException {
		logger.debug("Received application to be emailed.");

		String[] recipients = determineAdoptionRecipients(application, pet.getAnimal());

		MailMessage message = new AdoptionMailMessage(this.mailSession);
		message.setSubject(this.buildAdoptionSubject(application));
		message.addRecipients(recipients);
		message.setFrom(new InternetAddress(this.adoptionFrom));

		setAdoptionMailContent(application, pet, message);
		Transport.send(message);
	}

	public void sendErrorEmail(Exception e, String path) throws MessagingException {
		logger.info("Application exception has occured.  Sending message to the admin.");
		Date time = Calendar.getInstance().getTime();

		MailMessage message = new ExceptionMailMessage(this.mailSession);
		message.addRecipients(this.adminRecipients);
		message.setFrom(new InternetAddress(this.exceptionFrom));
		message.setSubject(this.exceptionSubject + " - " + time);
		message.setText(this.buildExceptionMessageText(e, path));
		Transport.send(message);
	}

	protected String buildAdoptionSubject(AdoptionApplication application) throws MessagingException {
		String subject = this.adoptionSubject;
		subject = subject.replace(SUBJECT_FIRST_NAME, application.getFirstName());
		subject = subject.replace(SUBJECT_LAST_NAME, application.getLastName());
		subject = subject.replace(SUBJECT_PET_NAME, application.getPetName());
		return subject;
	}

	protected String createAdoptionTextFromTemplate(AdoptionApplication application, PetfinderPetRecord pet)
			throws MessagingException {
		Map<String, Object> app = new HashMap<String, Object>();
		app.put("application", application);
		app.put("pet", pet);
		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
				"/com/systemsinmotion/petrescue/templates/adopt.vm", "UTF-8", app);
		return text;
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

	protected Session createMailSession() {
		return Session.getDefaultInstance(this.mailProperties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailManager.this.username, MailManager.this.password);
			}
		});
	}

	protected String[] determineAdoptionRecipients(AdoptionApplication application, AnimalType animalType)
			throws MessagingException, AddressException {
		String[] recipients = {};
		String applicantEmail = application.getEmail();
		if (StringUtils.hasText(applicantEmail) && applicantEmail.equals(adminRecipients[0])) {
			recipients = new String[] { adminRecipients[0] };
		} else if (animalType.equals(AnimalType.CAT)) {
			recipients = this.shelterCatRecipients;
		} else if (animalType.equals(AnimalType.DOG)) {
			recipients = this.shelterDogRecipients;
		}
		return recipients;
	}

	private String buildExceptionMessageText(Exception e, String path) throws MessagingException, AddressException {
		StringBuilder sb = new StringBuilder();
		sb.append("Error occured on ").append(this.shelterNameFull).append(" website when calling ").append(path);
		sb.append(" at ").append(Calendar.getInstance().getTime());
		sb.append("\n\n").append(ExceptionUtils.getStackTrace(e));
		return sb.toString();
	}

	private void setAdoptionMailContent(AdoptionApplication application, PetfinderPetRecord pet, MailMessage message)
			throws MessagingException {
		String text;
		String type;
		try {
			text = createAdoptionTextFromTemplate(application, pet);
			type = "text/html";
		} catch (VelocityException e) {
			text = application.toString();
			type = "text/plain";
		}
		message.setContent(text, type);
	}

}
