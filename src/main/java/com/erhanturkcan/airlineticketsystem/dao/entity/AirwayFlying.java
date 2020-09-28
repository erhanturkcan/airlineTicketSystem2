package com.erhanturkcan.airlineticketsystem.dao.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AIRWAY_FLYING")
public class AirwayFlying {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "CODE", length = 50)
	private String code;
	@Column(name = "AIRWAY_CODE", length = 50)
	private String airwayCode;
	@Column(name = "ROUTE_CODE", length = 50)
	private String routeCode;
	@Column(name="QUOTA", length =5)
	private Integer quota;
	@Column(name = "TICKET_PRICE")
	private BigDecimal ticketPrice;//base amount
	@Column(name="SELL_PRICE")
	private BigDecimal sellPrice;
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
