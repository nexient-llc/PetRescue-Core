package com.systemsinmotion.petrescue.mail;

import javax.mail.Session;

import com.systemsinmotion.petrescue.web.bean.AdoptionApplication;

public class AdoptionMailMessage extends MailMessage {

	@SuppressWarnings("unused")
	private AdoptionApplication application;

	public AdoptionMailMessage(Session session) {
		super(session);
	}

	public AdoptionMailMessage(Session session, AdoptionApplication application) {
		super(session);
		// TODO  - Either refactor the code to use application or remove this constructor.
	}

}
