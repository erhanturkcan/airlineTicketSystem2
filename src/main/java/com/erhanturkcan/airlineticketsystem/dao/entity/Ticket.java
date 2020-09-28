package com.erhanturkcan.airlineticketsystem.dao.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TICKET")
public class Ticket {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "CODE", length = 50)
	private String code;
	@Column(name = "AIRWAY_CODE", length = 50)
	private String airwayCode;
	@Column(name ="AIRWAY_FLYING_CODE", length = 50 )
	private String airwayFlyingCode;
	@Column(name = "NAME", length = 250)
	private String name;
	@Column(name = "PRICE")
	private BigDecimal price;
	@Column(name = "CREDIT_CARD", length = 20)
	private String creditCard;
	@Column(name = "FLY_DATE")
	private LocalDateTime flyDate;
	@Column(name = "STATUS", length = 10)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirwayCode() {
		return airwayCode;
	}

	public void setAirwayCode(String airwayCode) {
		this.airwayCode = airwayCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getFlyDate() {
		return flyDate;
	}

	public void setFlyDate(LocalDateTime flyDate) {
		this.flyDate = flyDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getAirwayFlyingCode() {
		return airwayFlyingCode;
	}

	public void setAirwayFlyingCode(String airwayFlyingCode) {
		this.airwayFlyingCode = airwayFlyingCode;
	}

}
