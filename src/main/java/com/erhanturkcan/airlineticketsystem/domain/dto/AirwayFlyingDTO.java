package com.erhanturkcan.airlineticketsystem.domain.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;


public class AirwayFlyingDTO {

	private Long id;
	@Size(max = 50)
	private String code;
	@Size(max = 50)
	private String airwayCode;
	@Size(max = 50)
	private String routeCode;
	@Size(max = 5)
	private Integer quota;
	private BigDecimal ticketPrice;//base amount.
	private BigDecimal sellPrice;
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
	public String getAirwayCode() {
		return airwayCode;
	}
	public void setAirwayCode(String airwayCode) {
		this.airwayCode = airwayCode;
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getQuota() {
		return quota;
	}
	public void setQuota(Integer quota) {
		this.quota = quota;
	}
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
	
}
