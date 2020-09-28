package com.erhanturkcan.airlineticketsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.erhanturkcan.airlineticketsystem.dao.entity.Airport;
import com.erhanturkcan.airlineticketsystem.domain.dto.AirportDTO;

@Mapper(componentModel = "spring")

public interface AirportMapper {

	AirportMapper instance = Mappers.getMapper(AirportMapper.class);

	Airport toAirportEntity(AirportDTO dto);

	AirportDTO toAirportDTO(Airport entity);

}
