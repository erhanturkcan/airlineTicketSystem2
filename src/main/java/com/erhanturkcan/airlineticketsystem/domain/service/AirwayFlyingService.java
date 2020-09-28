package com.erhanturkcan.airlineticketsystem.domain.service;

import java.util.List;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayFlyingDTO;

public interface AirwayFlyingService {

	AirwayFlyingDTO createAirwayFlying(AirwayFlyingDTO dto);

	List<AirwayFlyingDTO> searchAirwayFlyingbyCode(String airwayCode);

}
