package com.erhanturkcan.airlineticketsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.erhanturkcan.airlineticketsystem.dao.entity.AirwayCompany;
import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayCompanyDTO;

@Mapper(componentModel = "spring")
public interface AirwayCompanyMapper {

	AirwayCompanyMapper instance = Mappers.getMapper(AirwayCompanyMapper.class);
	
	AirwayCompany toAirwayCompanyEntity(AirwayCompanyDTO dto);
	
	AirwayCompanyDTO toAirwayCompanyDTO(AirwayCompany entity);

}
