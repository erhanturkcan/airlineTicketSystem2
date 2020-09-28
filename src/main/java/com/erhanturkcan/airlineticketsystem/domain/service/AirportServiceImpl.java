package com.erhanturkcan.airlineticketsystem.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erhanturkcan.airlineticketsystem.dao.repository.AirportRepository;
import com.erhanturkcan.airlineticketsystem.domain.dto.AirportDTO;
import com.erhanturkcan.airlineticketsystem.mapper.AirportMapper;

@Service
public class AirportServiceImpl implements AirportService {

	private AirportRepository repository;
	private AirportMapper mapper;

	@Autowired
	public AirportServiceImpl(AirportRepository repository, AirportMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public AirportDTO createAirport(AirportDTO dto) {
		return mapper.toAirportDTO(repository.save(mapper.toAirportEntity(dto)));
	}
	
	@Override
	public AirportDTO searchAirport(String code) {
		return mapper.toAirportDTO(repository.findByCode(code));
	}
	
	@Override
	public AirportDTO searchAirportByName(String name) {
		return mapper.toAirportDTO(repository.findByName(name));
	}

}
