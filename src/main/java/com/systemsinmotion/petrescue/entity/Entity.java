package com.systemsinmotion.petrescue.entity;

import java.io.Serializable;
import java.util.Date;

public class Entity implements Serializable {

	private static final long serialVersionUID = 119126717292593188L;

	private Date createdTimestamp;

	private String creator;

	private Date updatedTimestamp;

	private String updator;

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

}
