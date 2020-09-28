package com.erhanturkcan.airlineticketsystem.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erhanturkcan.airlineticketsystem.dao.repository.RouteRepository;
import com.erhanturkcan.airlineticketsystem.domain.dto.RouteDTO;
import com.erhanturkcan.airlineticketsystem.mapper.RouteMapper;

@Service
public class RouteServiceImpl implements RouteService {

	private RouteRepository repository;
	private RouteMapper mapper;

	@Autowired
	public RouteServiceImpl(RouteRepository repository, RouteMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public RouteDTO createRoute(RouteDTO dto) {
		return mapper.toRouteDTO(repository.save(mapper.toRouteEntity(dto)));
	}

	@Override
	public RouteDTO searchRouteByCodeOrDepartFrom(String code, String departFrom) {
		return mapper.toRouteDTO(repository.findByCodeOrDepartFrom(code, departFrom));
	}

}
