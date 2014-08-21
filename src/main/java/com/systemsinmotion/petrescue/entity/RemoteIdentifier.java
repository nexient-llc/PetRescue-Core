package com.systemsinmotion.petrescue.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.systemsinmotion.petrescue.entity.type.ApiType;

@Entity
@Table(name="remote_identifier")
public class RemoteIdentifier extends AbstractPersistable<Integer>  {

	private static final long serialVersionUID = 119126717292593188L;

	@Column(name="remote_id", length=30)
	private String remoteId;
	
	@Column(name="api")
	private ApiType api;
	
	@Column(name="last_updated")
	private Date lastUpdated;

	@JoinColumn(name="pet_id")
	private PetRecord pet;

	public String getRemoteId() {
		return remoteId;
	}

	public void setRemoteId(String remoteId) {
		this.remoteId = remoteId;
	}

	public ApiType getApi() {
		return api;
	}

	public void setApi(ApiType api) {
		this.api = api;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public PetRecord getPet() {
		return pet;
	}

	public void setPet(PetRecord pet) {
		this.pet = pet;
	}
}
