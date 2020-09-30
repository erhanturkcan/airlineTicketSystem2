package com.erhanturkcan.airlineticketsystem.dao.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.erhanturkcan.airlineticketsystem.dao.entity.Airport;

@RunWith(SpringRunner.class)
@Sql({"/Airport.sql"})
public class AirportRepositoryTest extends AbstractRepositoryTest{
	
	
	@Autowired
	private AirportRepository repository;
	
	@Test
	public void givenCode_whenFindByCode_thenShouldReturnAirport(){
		Airport airport = repository.findByCode("SAW");
		assertNotNull(airport);
		assertEquals(airport.getName(),"SABIHA GOKCEN HAVA LIMANI");
	}
	
	@Test
	public void givenCode_whenFindByName_thenShouldReturnAirport(){
		Airport airport = repository.findByName("SABIHA GOKCEN HAVA LIMANI");
		assertNotNull(airport);
		assertFalse(airport.getCode()==null);
	}

}
