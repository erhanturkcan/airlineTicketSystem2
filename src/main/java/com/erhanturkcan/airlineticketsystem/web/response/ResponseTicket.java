package com.erhanturkcan.airlineticketsystem.web.response;

import com.erhanturkcan.airlineticketsystem.domain.dto.TicketDTO;

public class ResponseTicket extends BaseResponse{

	private TicketDTO ticketDto;

	public TicketDTO getTicketDto() {
		return ticketDto;
	}

	public void setTicketDto(TicketDTO ticketDto) {
		this.ticketDto = ticketDto;
	}

}
