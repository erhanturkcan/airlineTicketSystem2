package com.erhanturkcan.airlineticketsystem.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.erhanturkcan.airlineticketsystem.domain.dto.TicketDTO;
import com.erhanturkcan.airlineticketsystem.domain.service.TicketService;
import com.erhanturkcan.airlineticketsystem.enums.ResponseStatus;
import com.erhanturkcan.airlineticketsystem.util.ValidateAndFormatUtil;
import com.erhanturkcan.airlineticketsystem.web.request.RequestSellTicket;
import com.erhanturkcan.airlineticketsystem.web.response.BaseResponse;
import com.erhanturkcan.airlineticketsystem.web.response.ResponseTicket;

import io.swagger.annotations.ApiOperation;

@Controller
public class TicketProcessController {

	@Autowired
	TicketService ticketService;

	@ApiOperation(value = "Sell ticket")
	@PostMapping(path = "/sellTicket")
	public ResponseEntity<ResponseTicket> buyTicket(@RequestBody RequestSellTicket request) throws Exception {

		ResponseTicket response = new ResponseTicket();
		BaseResponse baseResponse = null;
		if (request != null) {
			// validate request if necessary.
			// ValidateAndFormatUtil.maskCardNumber(request.getTicketDto().getCreditCard());
			baseResponse = ValidateAndFormatUtil.validateCreditCard(request.getTicketDto());
			if (baseResponse.getStatus().equals(ResponseStatus.SUCCESS)) {
				response.setTicketDto(ticketService.createTicket(request.getTicketDto()));
			}
			response.setErrorDesc(baseResponse.getErrorDesc());
			response.setErrorId(baseResponse.getErrorId());
			response.setStatus(baseResponse.getStatus());
		} else {
			return new ResponseEntity<ResponseTicket>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseTicket>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "search ticket  with name")
	@GetMapping(value = "/searchTicketByName/{name}")
	public ResponseEntity<ResponseTicket> searchTicketByName(@PathVariable String name) {
		ResponseTicket response = new ResponseTicket();
		if (name != null) {
			TicketDTO ticketDto = ticketService.searchTicketByName(name);
			if (ticketDto != null) {
				response.setTicketDto(ticketDto);
			} else {
				response.setStatus(ResponseStatus.FAILURE);
				response.setErrorId(10001L);
				response.setErrorDesc("record not found!");
			}
		} else {
			return new ResponseEntity<ResponseTicket>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseTicket>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "search ticket  with PNR")
	@GetMapping(value = "/searchTicketByCode/{code}")
	public ResponseEntity<ResponseTicket> searchTicketByCode(@PathVariable String code) {
		ResponseTicket response = new ResponseTicket();
		if (code != null) {
			TicketDTO ticketDto = ticketService.searchTicketByCode(code);
			if (ticketDto != null) {
				response.setTicketDto(ticketDto);
			} else {
				response.setStatus(ResponseStatus.FAILURE);
				response.setErrorId(10001L);
				response.setErrorDesc("record not found!");
			}
		} else {
			return new ResponseEntity<ResponseTicket>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseTicket>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "cancel ticket  with PNR")
	@PutMapping(value = "/cacelTicketByCode/{code}")
	public ResponseEntity<ResponseTicket> cancelByCode(@PathVariable String code) {
		ResponseTicket response = new ResponseTicket();
		if (code != null) {
			TicketDTO ticketDto = ticketService.searchTicketByCode(code);
			if (ticketDto != null) {
				ticketDto.setStatus("C");
				TicketDTO resultDto = ticketService.createTicket(ticketDto);

				response.setTicketDto(resultDto);
			} else {
				response.setStatus(ResponseStatus.FAILURE);
				response.setErrorId(10001L);
				response.setErrorDesc("record not found!");
			}
		} else {
			return new ResponseEntity<ResponseTicket>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseTicket>(response, HttpStatus.OK);
	}

}
