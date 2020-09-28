package com.erhanturkcan.airlineticketsystem.domain.dto;

import javax.validation.constraints.Size;

public class RouteDTO {

	private Long id;
	@Size(max = 50)
	private String code;
	@Size(max = 250)
	private String departFrom;
	@Size(max = 250)
	private String destination;
	private String estimatedFlyTime;
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

	public String getDepartFrom() {
		return departFrom;
	}

	public void setDepartFrom(String departFrom) {
		this.departFrom = departFrom;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getEstimatedFlyTime() {
		return estimatedFlyTime;
	}

	public void setEstimatedFlyTime(String estimatedFlyTime) {
		this.estimatedFlyTime = estimatedFlyTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
