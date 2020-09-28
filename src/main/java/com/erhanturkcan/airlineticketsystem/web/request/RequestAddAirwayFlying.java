package com.erhanturkcan.airlineticketsystem.web.request;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayFlyingDTO;

public class RequestAddAirwayFlying {

	private AirwayFlyingDTO airwayFlyingDto;

	public AirwayFlyingDTO getAirwayFlyingDto() {
		return airwayFlyingDto;
	}

	public void setAirwayFlyingDto(AirwayFlyingDTO airwayFlyingDto) {
		this.airwayFlyingDto = airwayFlyingDto;
	}

}
