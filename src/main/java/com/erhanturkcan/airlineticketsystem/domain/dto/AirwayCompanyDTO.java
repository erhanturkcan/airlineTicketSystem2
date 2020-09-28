package com.erhanturkcan.airlineticketsystem.domain.dto;

import javax.validation.constraints.Size;

public class AirwayCompanyDTO {

	private Long id;
	@Size(max = 50)
	private String code;
	@Size(max = 250)
	private String name;
	@Size(max = 10)
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
