package com.systemsinmotion.petrescue.mail;

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

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.systemsinmotion.petrescue.web.bean.AdoptionApplication;

@Component("emailManager")
public class MailManager {
	private static final Logger logger = Logger.getLogger(MailManager.class);

	private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	private static final String MAIL_SMTP_HOST = "mail.smtp.host";
	private static final String SUBJECT_FIRST_NAME = "[firstName]";
	private static final String SUBJECT_LAST_NAME = "[lastName]";
	private static final String SUBJECT_PET_NAME = "[petName]";
	private String from;
	private String host;
	private String password;
	private String[] recipients;
	private String subject;
	private String username;

	private void addRecipients(MimeMessage message) throws MessagingException, AddressException {
		for (String recipient : this.recipients) {
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		}
	}

	private void addSubject(MimeMessage message, AdoptionApplication application) throws MessagingException {
		String subject = this.subject;
		subject = subject.replace(SUBJECT_FIRST_NAME, application.getFirstName());
		subject = subject.replace(SUBJECT_LAST_NAME, application.getLastName());
		subject = subject.replace(SUBJECT_PET_NAME, application.getPetName());
		message.setSubject(subject);
	}

	private Properties createMailProperties() {
		Properties props = System.getProperties();
		props.put(MAIL_SMTP_HOST, this.host);
		props.put(MAIL_SMTP_AUTH, "true");
		return props;
	}

	private Session createSession(Properties props) {
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

	String[] getRecipients() {
		return this.recipients;
	}

	String getSubject() {
		return this.subject;
	}

	String getUsername() {
		return this.username;
	}

	@PostConstruct
	public void init() {
		Configuration config;
		try {
			config = new PropertiesConfiguration("shelter.properties");
			this.host = config.getString("shelter.email.host");
			this.username = config.getString("shelter.email.username");
			this.password = config.getString("shelter.email.password");
			this.from = config.getString("shelter.email.from");
			this.recipients = config.getString("shelter.email.recipients").split(";");
			this.subject = config.getString("shelter.email.subject");
		} catch (ConfigurationException e) {
			logger.error("File shelter.properties must exist in the classpath.");
			throw new RuntimeException(e);
		}
	}

	public void send(AdoptionApplication application) throws MessagingException {
		Properties props = createMailProperties();
		Session session = createSession(props);

		MimeMessage message = new MimeMessage(session);
		addSubject(message, application);
		addRecipients(message);
		message.setFrom(new InternetAddress(this.from));
		message.setText(toJson(application));

		Transport.send(message);
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

	void setRecipients(String[] recipients) {
		this.recipients = recipients;
	}

	void setSubject(String subject) {
		this.subject = subject;
	}

	void setUsername(String username) {
		this.username = username;
	}

	private String toJson(AdoptionApplication application) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(application);
	}

}
