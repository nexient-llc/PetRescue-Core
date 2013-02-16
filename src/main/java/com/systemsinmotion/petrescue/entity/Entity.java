package com.systemsinmotion.petrescue.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class Entity implements Serializable {

	private static final long serialVersionUID = 119126717292593188L;

	private Date createdTimestamp;

	private String creator;

	private Date updatedTimestamp;

	private String updator;

	@Column(name = "created_timestamp")
	public Date getCreatedTimestamp() {
		return this.createdTimestamp;
	}

	@Column(name = "creator", length = 20)
	public String getCreator() {
		return this.creator;
	}

	@Column(name = "updated_timestamp")
	public Date getUpdatedTimestamp() {
		return this.updatedTimestamp;
	}

	@Column(name = "updator", length = 20)
	public String getUpdator() {
		return this.updator;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

}
