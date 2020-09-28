package com.erhanturkcan.airlineticketsystem.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erhanturkcan.airlineticketsystem.dao.repository.TicketRepository;
import com.erhanturkcan.airlineticketsystem.domain.dto.TicketDTO;
import com.erhanturkcan.airlineticketsystem.mapper.TicketMapper;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository repository;
	private TicketMapper mapper;

	@Autowired
	public TicketServiceImpl(TicketRepository repository, TicketMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public TicketDTO createTicket(TicketDTO dto) {
		return mapper.toSoldTicketDTO(repository.save(mapper.toSoldTicketEntity(dto)));
	}
	
	@Override
	public Integer getSoldTicketCount(String flyingCode) {
		return repository.getsoldTicketCount(flyingCode);
	}

	@Override
	public TicketDTO searchTicketByName(String name) {
		return mapper.toSoldTicketDTO(repository.findByName(name));
	}

	@Override
	public TicketDTO searchTicketByCode(String code) {
		return mapper.toSoldTicketDTO(repository.findByCode(code));
	}
}
