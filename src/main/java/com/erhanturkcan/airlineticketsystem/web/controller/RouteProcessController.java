package com.erhanturkcan.airlineticketsystem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erhanturkcan.airlineticketsystem.domain.dto.RouteDTO;
import com.erhanturkcan.airlineticketsystem.domain.service.RouteService;
import com.erhanturkcan.airlineticketsystem.enums.ResponseStatus;
import com.erhanturkcan.airlineticketsystem.web.request.RequestAddRoute;
import com.erhanturkcan.airlineticketsystem.web.response.ResponseRoute;

import io.swagger.annotations.ApiOperation;

@Controller
public class RouteProcessController {

	@Autowired
	RouteService routeService;

	@ApiOperation(value = "add route")
	@PostMapping(path = "/addRoute")
	public ResponseEntity<ResponseRoute> addAirport(@RequestBody RequestAddRoute request) {

		// validate request if necessary.
		ResponseRoute response = new ResponseRoute();
		if (request != null) {
			response.setRouteDto(routeService.createRoute(request.getRouteDto()));
		} else {
			return new ResponseEntity<ResponseRoute>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseRoute>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "search route  with code")
	@GetMapping(value = "/searchRouteByCodeorDepartFrom")
	@ResponseBody
	public ResponseEntity<ResponseRoute> searchAirwayCompanyWithName(@RequestParam(required = false, name = "code") String code,
			@RequestParam(required = false,name ="departFrom") String departFrom) {
		ResponseRoute response = new ResponseRoute();
		if (code != null) {
			RouteDTO routeDto = routeService.searchRouteByCodeOrDepartFrom(code, departFrom);
			if (routeDto != null) {
				response.setRouteDto(routeDto);
			} else {
				response.setStatus(ResponseStatus.FAILURE);
				response.setErrorId(10001L);
				response.setErrorDesc("record not found!");
			}
		} else {
			return new ResponseEntity<ResponseRoute>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseRoute>(response, HttpStatus.OK);
	}

}
