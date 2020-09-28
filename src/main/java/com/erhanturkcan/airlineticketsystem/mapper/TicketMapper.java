package com.erhanturkcan.airlineticketsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.erhanturkcan.airlineticketsystem.dao.entity.Ticket;
import com.erhanturkcan.airlineticketsystem.domain.dto.TicketDTO;

@Mapper(componentModel = "spring")
public interface TicketMapper {

	TicketMapper instance = Mappers.getMapper(TicketMapper.class);
	
	Ticket toSoldTicketEntity(TicketDTO dto);
	
	TicketDTO toSoldTicketDTO(Ticket entity);
	
}

