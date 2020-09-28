package com.erhanturkcan.airlineticketsystem.web.request;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirportDTO;

public class RequestAddAirport {

	private AirportDTO airportDto;

	public AirportDTO getAirportDto() {
		return airportDto;
	}

	public void setAirportDto(AirportDTO airportDto) {
		this.airportDto = airportDto;
	}

}
