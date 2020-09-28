package com.erhanturkcan.airlineticketsystem.web.response;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirportDTO;

public class ResponseAirport extends BaseResponse{

	private AirportDTO airportDto;

	public AirportDTO getAirportDto() {
		return airportDto;
	}

	public void setAirportDto(AirportDTO airportDto) {
		this.airportDto = airportDto;
	}

}
