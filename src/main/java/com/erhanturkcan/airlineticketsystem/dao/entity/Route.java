package com.erhanturkcan.airlineticketsystem.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROUTE")
public class Route {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "CODE", length = 50)
	private String code;
	@Column(name = "DEPART_FROM", length = 250)
	private String departFrom;
	@Column(name = "DESTINATION", length = 250)
	private String destination;
	@Column(name = "ESTIMATED_FLY_TIME")
	private String estimatedFlyTime;
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
