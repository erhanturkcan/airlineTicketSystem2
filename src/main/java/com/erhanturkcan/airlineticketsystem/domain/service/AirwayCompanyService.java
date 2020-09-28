package com.erhanturkcan.airlineticketsystem.domain.service;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayCompanyDTO;

public interface AirwayCompanyService {

	AirwayCompanyDTO createAirwayCompany(AirwayCompanyDTO dto);

	AirwayCompanyDTO searchAirwayCompanyByName(String code);

	AirwayCompanyDTO searchAirwayCompanyByCode(String code);

}
