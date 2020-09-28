package com.erhanturkcan.airlineticketsystem.domain.service;

import com.erhanturkcan.airlineticketsystem.domain.dto.TicketDTO;

public interface TicketService {

	TicketDTO createTicket(TicketDTO dto);

	Integer getSoldTicketCount(String flyingCode);

	TicketDTO searchTicketByName(String name);

	TicketDTO searchTicketByCode(String code);

}
