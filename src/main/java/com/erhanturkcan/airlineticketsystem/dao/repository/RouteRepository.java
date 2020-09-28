package com.erhanturkcan.airlineticketsystem.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erhanturkcan.airlineticketsystem.dao.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long>, JpaSpecificationExecutor<Route> {

	@Query("Select r from Route r where (r.code is null or r.code= :code) and (r. departFrom is null or r.departFrom= :departFrom)")
	Route findByCodeOrDepartFrom(@Param("code") String code, @Param("departFrom") String departFrom);

}
