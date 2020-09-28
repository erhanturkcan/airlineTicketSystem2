package com.erhanturkcan.airlineticketsystem.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AIRWAY_COMPANY")
public class AirwayCompany {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "CODE", length = 50)
	private String code;
	@Column(name = "NAME", length = 250)
	private String name;
	@Column(name = "STATUS", length = 10)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
