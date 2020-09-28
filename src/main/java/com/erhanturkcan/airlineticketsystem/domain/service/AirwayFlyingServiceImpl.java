package com.erhanturkcan.airlineticketsystem.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erhanturkcan.airlineticketsystem.dao.repository.AirwayFlyingRepository;
import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayFlyingDTO;
import com.erhanturkcan.airlineticketsystem.mapper.AirwayFlyingMapper;

@Service
public class AirwayFlyingServiceImpl implements AirwayFlyingService {

	private AirwayFlyingRepository repository;
	private AirwayFlyingMapper mapper;

	@Autowired
	public AirwayFlyingServiceImpl(AirwayFlyingRepository repository, AirwayFlyingMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public AirwayFlyingDTO createAirwayFlying(AirwayFlyingDTO dto) {
		return mapper.toAirwayFlyingDTO(repository.save(mapper.toAirwayFlyingEntity(dto)));
	}

	@Override
	public List<AirwayFlyingDTO> searchAirwayFlyingbyCode(String airwayCode) {
		return mapper.toAirwayFlyingDTOList(repository.findByAirwayCode(airwayCode));
	}

}
