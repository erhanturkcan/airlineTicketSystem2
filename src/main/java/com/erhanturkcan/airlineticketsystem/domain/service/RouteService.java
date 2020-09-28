package com.erhanturkcan.airlineticketsystem.domain.service;

import com.erhanturkcan.airlineticketsystem.domain.dto.RouteDTO;

public interface RouteService {

	RouteDTO createRoute(RouteDTO dto);

	RouteDTO searchRouteByCodeOrDepartFrom(String code, String departFrom);

}
