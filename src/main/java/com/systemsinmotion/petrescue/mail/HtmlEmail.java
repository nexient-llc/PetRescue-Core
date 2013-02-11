package com.systemsinmotion.petrescue.mail;

import com.systemsinmotion.petrescue.web.bean.AdoptionApplication;

public class HtmlEmail {
	@SuppressWarnings("unused")
	private AdoptionApplication application;

	public HtmlEmail(AdoptionApplication application) {
		this.application = application;
	}
}
