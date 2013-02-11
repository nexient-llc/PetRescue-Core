package com.systemsinmotion.petrescue.web.bean;

import java.io.Serializable;

public class Vet implements Serializable {
	private static final long serialVersionUID = -4313027343672016633L;

	private String name;

	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
