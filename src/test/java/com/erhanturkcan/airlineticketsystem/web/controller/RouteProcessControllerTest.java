package com.erhanturkcan.airlineticketsystem.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.erhanturkcan.airlineticketsystem.domain.dto.RouteDTO;
import com.erhanturkcan.airlineticketsystem.domain.service.RouteService;
import com.erhanturkcan.airlineticketsystem.mapper.RouteMapper;
import com.erhanturkcan.airlineticketsystem.util.TestUtil;

@WebMvcTest(controllers = RouteProcessController.class)
@ComponentScan(basePackageClasses = { RouteMapper.class })
public class RouteProcessControllerTest extends AbstractControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RouteService service;

	private final String URL = "/searchRouteByCodeorDepartFrom";

	@Test
	public void givenCodeAndDepartFrom_whenGetRoute_thenShouldReturnHttpOkAndRoute() throws Exception {
		RouteDTO routeDto = TestUtil.getRoute();
		when(service.searchRouteByCodeOrDepartFrom(Mockito.anyString(), Mockito.anyString())).thenReturn(routeDto);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL + "/code=ROU001&departFrom=IST")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();
		int status = result.getResponse().getStatus();
		assertThat(status).isEqualTo(HttpStatus.OK);
	}

}
