package com.tbutler78.minemapping.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "county_100k")
public class County100k {
	@Id
	private Long id;

	private String countyName;
	private String hundredKQuad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getHundredKQuad() {
		return hundredKQuad;
	}

	public void setHundredKQuad(String hundredKQuad) {
		this.hundredKQuad = hundredKQuad;
	}

	@Override
	public String toString() {
		return "County100k{" +
				"id=" + id +
				", countyName='" + countyName + '\'' +
				", hundredKQuad='" + hundredKQuad + '\'' +
				'}';
	}
}
