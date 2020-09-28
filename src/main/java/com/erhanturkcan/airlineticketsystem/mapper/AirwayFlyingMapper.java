package com.erhanturkcan.airlineticketsystem.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.erhanturkcan.airlineticketsystem.dao.entity.AirwayFlying;
import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayFlyingDTO;

@Mapper(componentModel = "spring")
public interface AirwayFlyingMapper {

	AirwayFlyingMapper instance = Mappers.getMapper(AirwayFlyingMapper.class);

	AirwayFlying toAirwayFlyingEntity(AirwayFlyingDTO dto);

	AirwayFlyingDTO toAirwayFlyingDTO(AirwayFlying entity);
	
	List<AirwayFlyingDTO> toAirwayFlyingDTOList(List<AirwayFlying> entity);

}
