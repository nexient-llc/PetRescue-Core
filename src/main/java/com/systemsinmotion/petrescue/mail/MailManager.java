package com.systemsinmotion.petrescue.mail;

import java.util.Calendar;
import java.util.Date;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
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

	@Value("${shelter.email.recipients}")
	private String shelterRecipeintList;

	@Value("${admin.email.recipients}")
	private String adminRecipeintList;

	private String[] shelterRecipients;

	private String[] adminRecipients;

	@Value("${shelter.email.subject}")
	private String subject;

	@Value("${shelter.email.username}")
	private String username;

	@Value("${shelter.name.full}")
	private String sheltername;

	@Value("${shelter.name.abv}")
	private String shelterabv;

	private void addRecipients(MimeMessage message, AdoptionApplication application) throws MessagingException, AddressException {
		String email = application.getEmail();
		if (StringUtils.hasText(email) && email.equals("keithskronek@gmail.com")) {
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("keithskronek@gmail.com"));
		} else {
			for (String recipient : this.shelterRecipients) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			}
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

		// Google Connection Info
		// final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// props.setProperty("mail.smtps.host", "smtp.gmail.com");
		// props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		// props.setProperty("mail.smtp.socketFactory.fallback", "false");
		// props.setProperty("mail.smtp.port", "465");
		// props.setProperty("mail.smtp.socketFactory.port", "465");
		// props.setProperty("mail.smtps.auth", "true");
		// props.put("mail.smtps.quitwait", "false");

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
		this.shelterRecipients = this.shelterRecipeintList.split(";");
		this.adminRecipients = this.adminRecipeintList.split(";");
	}

	public void send(AdoptionApplication application) throws MessagingException {
		logger.debug("Received application to be emailed.");

		Properties props = createMailProperties();
		Session session = createSession(props);

		MimeMessage message = new MimeMessage(session);
		addSubject(message, application);
		addRecipients(message, application);
		message.setFrom(new InternetAddress(this.from));
		message.setText(toJson(application));

		Transport.send(message);
	}

	public void send_error(Exception e, String path) throws MessagingException {
		logger.debug("Error occured, sending message to the admin");

		Properties props = createMailProperties();
		Session session = createSession(props);

		MimeMessage message = new MimeMessage(session);
		setErrorMessageFields(e, path, message);
		try {
			Transport.send(message);
			
			// Google connection method
			// SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
			// t.connect("smtp.gmail.com", username, password);
			// t.sendMessage(message, message.getAllRecipients());
			// t.close();
			
		} catch (Exception e2) {
			// There's nothing more to report at this level
			logger.debug("Error! Email Failed to get sended");
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

	void setUsername(String username) {
		this.username = username;
	}

	private String toJson(AdoptionApplication application) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(application);
	}

}
