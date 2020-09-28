package com.erhanturkcan.airlineticketsystem.web.request;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayCompanyDTO;

public class RequestAddAirwayCompany {

	private AirwayCompanyDTO airwayCompanyDto;

	public AirwayCompanyDTO getAirwayCompanyDto() {
		return airwayCompanyDto;
	}

	public void setAirwayCompanyDto(AirwayCompanyDTO airwayCompanyDto) {
		this.airwayCompanyDto = airwayCompanyDto;
	}

}
