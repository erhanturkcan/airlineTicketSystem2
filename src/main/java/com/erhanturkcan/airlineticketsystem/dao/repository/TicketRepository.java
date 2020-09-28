package com.erhanturkcan.airlineticketsystem.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.erhanturkcan.airlineticketsystem.dao.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket> {

	@Query("select count(r) from Ticket r where r.airwayFlyingCode= :flyingCode group by r.airwayFlyingCode")
	Integer getsoldTicketCount(String flyingCode);

	Ticket findByName(String name);

	Ticket findByCode(String code);

}
