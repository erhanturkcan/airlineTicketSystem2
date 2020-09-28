package com.erhanturkcan.airlineticketsystem.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.erhanturkcan.airlineticketsystem.dao.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>, JpaSpecificationExecutor<Airport> {

	Airport findByCode(String code);

	Airport findByName(String name);
}
