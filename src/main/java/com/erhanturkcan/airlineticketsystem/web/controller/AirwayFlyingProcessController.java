package com.erhanturkcan.airlineticketsystem.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayFlyingDTO;
import com.erhanturkcan.airlineticketsystem.domain.service.AirwayFlyingService;
import com.erhanturkcan.airlineticketsystem.enums.ResponseStatus;
import com.erhanturkcan.airlineticketsystem.util.TicketUtil;
import com.erhanturkcan.airlineticketsystem.web.request.RequestAddAirwayFlying;
import com.erhanturkcan.airlineticketsystem.web.response.ResponseAirwayFlying;

import io.swagger.annotations.ApiOperation;

@Controller
public class AirwayFlyingProcessController {

	@Autowired
	AirwayFlyingService airwayFlyingService;
	@Autowired
	TicketUtil ticketUtil;

	@ApiOperation(value = "add airway flying")
	@PostMapping(path = "/addAirwayFlying")
	public ResponseEntity<ResponseAirwayFlying> addAirwayFlying(@RequestBody RequestAddAirwayFlying request) {

		// validate request if necessary.
		ResponseAirwayFlying response = new ResponseAirwayFlying();
		if (request != null) {
			List<AirwayFlyingDTO> dtoList = new ArrayList<AirwayFlyingDTO>();
			response.setAirwayFlyingDto(dtoList);
			response.getAirwayFlyingDto().add(airwayFlyingService.createAirwayFlying(request.getAirwayFlyingDto()));
		} else {
			return new ResponseEntity<ResponseAirwayFlying>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseAirwayFlying>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "search airway flying with code")
	@GetMapping(value = "/searchAirwayFlyingByAirwayCode/{airwayCode}")
	public ResponseEntity<ResponseAirwayFlying> searchAirportWithCode(@PathVariable String airwayCode) {
		ResponseAirwayFlying response = new ResponseAirwayFlying();
		if (airwayCode != null) {
			List<AirwayFlyingDTO> dtoList = new ArrayList<AirwayFlyingDTO>();
			response.setAirwayFlyingDto(dtoList);
			List<AirwayFlyingDTO> airwayFlyingDtoList = airwayFlyingService.searchAirwayFlyingbyCode(airwayCode);
			if (!CollectionUtils.isEmpty(airwayFlyingDtoList)) {
				for (AirwayFlyingDTO airwayFlyingDto : airwayFlyingDtoList) {					
					AirwayFlyingDTO resultDto = ticketUtil.prepareSellPrice(airwayFlyingDto);
					if (resultDto.getSellPrice().compareTo(BigDecimal.ZERO)==0) {
						response.setStatus(ResponseStatus.FAILURE);
						response.setErrorId(10001L);
						response.setErrorDesc("fly full!");
					}
					response.getAirwayFlyingDto().add(airwayFlyingDto);
				}
			} else {
				response.setStatus(ResponseStatus.FAILURE);
				response.setErrorId(10001L);
				response.setErrorDesc("record not found!");
			}
		} else {
			return new ResponseEntity<ResponseAirwayFlying>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseAirwayFlying>(response, HttpStatus.OK);

	}
}
