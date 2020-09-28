package com.erhanturkcan.airlineticketsystem.domain.service;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirportDTO;

public interface AirportService {

	AirportDTO createAirport(AirportDTO dto);

	AirportDTO searchAirport(String code);

	AirportDTO searchAirportByName(String name);

}
