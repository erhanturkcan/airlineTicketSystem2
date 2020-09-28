package com.erhanturkcan.airlineticketsystem.web.response;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayCompanyDTO;

public class ResponseAirwayCompany extends BaseResponse{

	private AirwayCompanyDTO airwayCompanyDto;

	public AirwayCompanyDTO getAirwayCompanyDto() {
		return airwayCompanyDto;
	}

	public void setAirwayCompanyDto(AirwayCompanyDTO airwayCompanyDto) {
		this.airwayCompanyDto = airwayCompanyDto;
	}

}
