package com.erhanturkcan.airlineticketsystem.web.request;

import com.erhanturkcan.airlineticketsystem.domain.dto.TicketDTO;

public class RequestSellTicket {

	private TicketDTO ticketDto;

	public TicketDTO getTicketDto() {
		return ticketDto;
	}

	public void setTicketDto(TicketDTO ticketDto) {
		this.ticketDto = ticketDto;
	}

}
