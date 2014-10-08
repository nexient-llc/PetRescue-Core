package com.systemsinmotion.petrescue.mail;

import javax.mail.Session;

public class ExceptionMailMessage extends MailMessage {

	public ExceptionMailMessage(Session session) {
		super(session);
	}

}
