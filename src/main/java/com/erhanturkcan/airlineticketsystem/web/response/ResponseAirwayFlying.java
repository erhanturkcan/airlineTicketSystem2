package com.erhanturkcan.airlineticketsystem.web.response;

import java.util.List;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayFlyingDTO;

public class ResponseAirwayFlying extends BaseResponse{

	private List<AirwayFlyingDTO> airwayFlyingDto;

	public List<AirwayFlyingDTO> getAirwayFlyingDto() {
		return airwayFlyingDto;
	}

	public void setAirwayFlyingDto(List<AirwayFlyingDTO> airwayFlyingDto) {
		this.airwayFlyingDto = airwayFlyingDto;
	}

	

}
