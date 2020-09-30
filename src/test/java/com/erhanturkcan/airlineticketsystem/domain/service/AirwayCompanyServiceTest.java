package com.erhanturkcan.airlineticketsystem.domain.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.erhanturkcan.airlineticketsystem.dao.repository.AirwayCompanyRepository;
import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayCompanyDTO;
import com.erhanturkcan.airlineticketsystem.mapper.AirwayCompanyMapper;
import com.erhanturkcan.airlineticketsystem.util.TestUtil;

@RunWith(MockitoJUnitRunner.class)
public class AirwayCompanyServiceTest {

	private AirwayCompanyService service;
	
	@Mock
	private AirwayCompanyRepository repositoryMock;
	
	@Before
	public void setUp(){
		service = new AirwayCompanyServiceImpl(repositoryMock, AirwayCompanyMapper.instance);
	}
	
	@Test
	public void whenGetAirwayCompanybyCode_thenReturnCompany() {
		when(repositoryMock.findByCode(Mockito.anyString())).thenReturn(TestUtil.getAirwaCompany());
		AirwayCompanyDTO response = service.searchAirwayCompanyByCode("PGS");
		assertNotNull(response);
		assertEquals(response.getName(), TestUtil.AIRWAY_COMPANY_NAME);
	}
	
}
