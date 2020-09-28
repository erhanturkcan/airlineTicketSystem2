package com.erhanturkcan.airlineticketsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.erhanturkcan.airlineticketsystem.dao.entity.Route;
import com.erhanturkcan.airlineticketsystem.domain.dto.RouteDTO;

@Mapper(componentModel = "spring")

public interface RouteMapper {

	RouteMapper instance = Mappers.getMapper(RouteMapper.class);

	Route toRouteEntity(RouteDTO dto);

	RouteDTO toRouteDTO(Route entity);

}
