package com.erhanturkcan.airlineticketsystem.web.response;

import com.erhanturkcan.airlineticketsystem.domain.dto.RouteDTO;

public class ResponseRoute extends BaseResponse{

	private RouteDTO routeDto;

	public RouteDTO getRouteDto() {
		return routeDto;
	}

	public void setRouteDto(RouteDTO routeDto) {
		this.routeDto = routeDto;
	}

}
