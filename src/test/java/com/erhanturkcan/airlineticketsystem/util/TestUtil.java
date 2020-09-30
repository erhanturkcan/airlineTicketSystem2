package com.erhanturkcan.airlineticketsystem.util;

import com.erhanturkcan.airlineticketsystem.dao.entity.AirwayCompany;
import com.erhanturkcan.airlineticketsystem.domain.dto.RouteDTO;

public final class TestUtil {

	public static final String AIRWAY_COMPANY_CODE = "PGS";
	public static final String AIRWAY_COMPANY_NAME = "PEGASUS";

	public static AirwayCompany getAirwaCompany() {
		AirwayCompany company = new AirwayCompany();
		company.setCode("PGS");
		company.setName("PEGASUS");
		company.setStatus("A");
		return company;
	}

	public static RouteDTO getRoute() {
		RouteDTO routeDto = new RouteDTO();
		routeDto.setCode("ROU001");
		routeDto.setDepartFrom("IST");
		routeDto.setDestination("ANK");
		routeDto.setEstimatedFlyTime("1h");
		routeDto.setStatus("A");
		return routeDto; 
	}
}
