package com.erhanturkcan.airlineticketsystem.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erhanturkcan.airlineticketsystem.dao.repository.AirwayCompanyRepository;
import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayCompanyDTO;
import com.erhanturkcan.airlineticketsystem.mapper.AirwayCompanyMapper;

@Service
public class AirwayCompanyServiceImpl implements AirwayCompanyService {

	private AirwayCompanyRepository repository;
	private AirwayCompanyMapper mapper;

	@Autowired
	public AirwayCompanyServiceImpl(AirwayCompanyRepository repository, AirwayCompanyMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public AirwayCompanyDTO createAirwayCompany(AirwayCompanyDTO dto) {
		return mapper.toAirwayCompanyDTO(repository.save(mapper.toAirwayCompanyEntity(dto)));
	}

	@Override
	public AirwayCompanyDTO searchAirwayCompanyByName(String name) {
		return mapper.toAirwayCompanyDTO(repository.findByName(name));
	}

	@Override
	public AirwayCompanyDTO searchAirwayCompanyByCode(String code) {
		return mapper.toAirwayCompanyDTO(repository.findByCode(code));
	}
}
