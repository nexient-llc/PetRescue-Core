package com.systemsinmotion.petrescue.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public abstract class MailMessage extends MimeMessage {

	public MailMessage(Session session) {
		super(session);
	}
	
	void addRecipients(String[] recipients) throws MessagingException, AddressException {
		for (String recipient : recipients) {
			addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		}
	}
}
