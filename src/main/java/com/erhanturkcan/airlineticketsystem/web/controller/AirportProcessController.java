package com.erhanturkcan.airlineticketsystem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirportDTO;
import com.erhanturkcan.airlineticketsystem.domain.service.AirportService;
import com.erhanturkcan.airlineticketsystem.enums.ResponseStatus;
import com.erhanturkcan.airlineticketsystem.web.request.RequestAddAirport;
import com.erhanturkcan.airlineticketsystem.web.response.ResponseAirport;

import io.swagger.annotations.ApiOperation;

@Controller
public class AirportProcessController {

	@Autowired
	AirportService airportService;

	@ApiOperation(value = "add airport")
	@PostMapping(path = "/addAirport")
	public ResponseEntity<ResponseAirport> addAirport(@RequestBody RequestAddAirport request) {

		// validate request if necessary.
		ResponseAirport response = new ResponseAirport();
		if (request != null) {
			response.setAirportDto(airportService.createAirport(request.getAirportDto()));
		} else {
			return new ResponseEntity<ResponseAirport>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseAirport>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "search airport with code")
	@GetMapping(value = "/searchAirportByCode/{code}")
	public ResponseEntity<ResponseAirport> searchAirportWithCode(@PathVariable String code) {
		ResponseAirport response = new ResponseAirport();
		if (code != null) {
			AirportDTO airportDto = airportService.searchAirport(code);
			if (airportDto != null) {
				response.setAirportDto(airportDto);
			} else {
				response.setStatus(ResponseStatus.FAILURE);
				response.setErrorId(10001L);
				response.setErrorDesc("record not found!");
			}
		} else {
			return new ResponseEntity<ResponseAirport>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseAirport>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "search airport with name")
	@GetMapping(value = "/searchAirportByName/{name}")
	public ResponseEntity<ResponseAirport> searchAirportWithName(@PathVariable String name) {
		ResponseAirport response = new ResponseAirport();
		if (name != null) {
			AirportDTO airportDto = airportService.searchAirportByName(name);
			if (airportDto != null) {
				response.setAirportDto(airportDto);
			} else {
				response.setStatus(ResponseStatus.FAILURE);
				response.setErrorId(10001L);
				response.setErrorDesc("record not found!");
			}
		} else {
			return new ResponseEntity<ResponseAirport>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseAirport>(response, HttpStatus.OK);

	}

}
