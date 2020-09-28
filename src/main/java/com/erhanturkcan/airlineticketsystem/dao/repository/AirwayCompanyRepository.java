package com.erhanturkcan.airlineticketsystem.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.erhanturkcan.airlineticketsystem.dao.entity.AirwayCompany;

public interface AirwayCompanyRepository
		extends JpaRepository<AirwayCompany, Long>, JpaSpecificationExecutor<AirwayCompany> {

	AirwayCompany findByName(String name);

	AirwayCompany findByCode(String code);

}
