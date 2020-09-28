package com.erhanturkcan.airlineticketsystem.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Size;

public class TicketDTO {

	private Long id;
	@Size(max = 50)
	private String code;
	@Size(max = 50)
	private String airwayCode;
	@Size(max = 50)
	private String airwayFlyingCode;
	@Size(max = 250)
	private String name;
	@Size(max = 18)
	private BigDecimal price;
	@Size(max = 20)
	private String creditCard;
	private LocalDateTime flyDate;
	@Size(max = 10)
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getFlyDate() {
		return flyDate;
	}

	public void setFlyDate(LocalDateTime flyDate) {
		this.flyDate = flyDate;
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
