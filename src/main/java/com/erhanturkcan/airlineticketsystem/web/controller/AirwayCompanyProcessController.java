package com.erhanturkcan.airlineticketsystem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayCompanyDTO;
import com.erhanturkcan.airlineticketsystem.domain.service.AirwayCompanyService;
import com.erhanturkcan.airlineticketsystem.enums.ResponseStatus;
import com.erhanturkcan.airlineticketsystem.web.request.RequestAddAirwayCompany;
import com.erhanturkcan.airlineticketsystem.web.response.ResponseAirwayCompany;

import io.swagger.annotations.ApiOperation;

@Controller
public class AirwayCompanyProcessController {

	@Autowired
	AirwayCompanyService airwayCompanyService;

	@ApiOperation(value = "add airway company")
	@PostMapping(path = "/addAirwayCompany")
	public ResponseEntity<ResponseAirwayCompany> addAirport(@RequestBody RequestAddAirwayCompany request) {

		// validate request if necessary.
		ResponseAirwayCompany response = new ResponseAirwayCompany();
		if (request != null) {
			response.setAirwayCompanyDto(airwayCompanyService.createAirwayCompany(request.getAirwayCompanyDto()));
		} else {
			return new ResponseEntity<ResponseAirwayCompany>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseAirwayCompany>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "search airway company with code")
	@GetMapping(value = "/searchAirwayCompanyByCode/{code}")
	public ResponseEntity<ResponseAirwayCompany> searchAirwayCompanyByCode(@PathVariable String code) {
		ResponseAirwayCompany response = new ResponseAirwayCompany();
		if (code != null) {
			AirwayCompanyDTO airwayCompanyDto = airwayCompanyService.searchAirwayCompanyByCode(code);
			if (airwayCompanyDto != null) {
				response.setAirwayCompanyDto(airwayCompanyDto);
			} else {
				response.setStatus(ResponseStatus.FAILURE);
				response.setErrorId(10001L);
				response.setErrorDesc("record not found!");
			}
		} else {
			return new ResponseEntity<ResponseAirwayCompany>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseAirwayCompany>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "search airway company with name")
	@GetMapping(value = "/searchAirwayCompanyByName/{name}")
	public ResponseEntity<ResponseAirwayCompany> searchAirwayCompanyByName(@PathVariable String name) {
		ResponseAirwayCompany response = new ResponseAirwayCompany();
		if (name != null) {
			AirwayCompanyDTO airwayCompanyDto = airwayCompanyService.searchAirwayCompanyByName(name);
			if (airwayCompanyDto != null) {
				response.setAirwayCompanyDto(airwayCompanyDto);
			} else {
				response.setStatus(ResponseStatus.FAILURE);
				response.setErrorId(10001L);
				response.setErrorDesc("record not found!");
			}
		} else {
			return new ResponseEntity<ResponseAirwayCompany>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseAirwayCompany>(response, HttpStatus.OK);
	}
}
