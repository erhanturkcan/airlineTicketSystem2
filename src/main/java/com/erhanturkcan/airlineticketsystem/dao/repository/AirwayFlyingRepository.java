package com.erhanturkcan.airlineticketsystem.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.erhanturkcan.airlineticketsystem.dao.entity.AirwayFlying;

public interface AirwayFlyingRepository
		extends JpaRepository<AirwayFlying, Long>, JpaSpecificationExecutor<AirwayFlying> {

	List<AirwayFlying> findByAirwayCode(String airwayCode);

}
