package com.erhanturkcan.airlineticketsystem.web.request;

import com.erhanturkcan.airlineticketsystem.domain.dto.RouteDTO;

public class RequestAddRoute {

	private RouteDTO routeDto;

	public RouteDTO getRouteDto() {
		return routeDto;
	}

	public void setRouteDto(RouteDTO routeDto) {
		this.routeDto = routeDto;
	}

}
