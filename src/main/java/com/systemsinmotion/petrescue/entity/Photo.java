package com.systemsinmotion.petrescue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "photo")
public class Photo extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 7179570524027044221L;

	@Column(name = "size", length = 3, nullable = false)
	private String size;

	@Column(name = "url", length = 255, nullable = false)
	private String url;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
