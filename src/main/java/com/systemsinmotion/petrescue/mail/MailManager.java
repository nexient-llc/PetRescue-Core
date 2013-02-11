package com.systemsinmotion.petrescue.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.systemsinmotion.petrescue.web.bean.AdoptionApplication;

public class MailManager {
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
		for (String recipient : recipients) {
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		}
	}

	private void addSubject(MimeMessage message, AdoptionApplication application) throws MessagingException {
		String subject = this.subject;
		subject = subject.replace(SUBJECT_FIRST_NAME, application.getFirstName());
		subject = subject.replace(SUBJECT_LAST_NAME, application.getLastName());
		subject = subject.replace(SUBJECT_PET_NAME, application.getPet().getName());
		message.setSubject(subject);
	}

	private Properties createProperties() {
		Properties props = System.getProperties();
		props.put(MAIL_SMTP_HOST, this.host);
		props.put(MAIL_SMTP_AUTH, "true");
		return props;
	}

	private Session createSession(Properties props) {
		return Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	public void send(AdoptionApplication application) throws AddressException, MessagingException {
		Properties props = createProperties();
		Session session = createSession(props);

		MimeMessage message = new MimeMessage(session);
		addSubject(message, application);
		addRecipients(message);
		message.setFrom(new InternetAddress(this.from));
		message.setText(application.toString());

		Transport.send(message);
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRecipients(String[] to) {
		this.recipients = to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
