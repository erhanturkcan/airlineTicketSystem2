package com.erhanturkcan.airlineticketsystem.util;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.erhanturkcan.airlineticketsystem.domain.dto.AirwayFlyingDTO;
import com.erhanturkcan.airlineticketsystem.domain.service.TicketService;

@Component
public class TicketUtil {

	public static final float ticketRaisePersistance = 0.1f;

	@Autowired
	TicketService ticketService;

	public AirwayFlyingDTO prepareSellPrice(AirwayFlyingDTO airwayFlyingDto) {
		Integer soldTicketCount = ticketService.getSoldTicketCount(airwayFlyingDto.getCode());
		Integer quota = airwayFlyingDto.getQuota();
		Integer soldTicketPersistance = soldTicketCount * 100 / quota;
		BigDecimal basePrice = airwayFlyingDto.getTicketPrice();

		int raiseCount = (int) Math.floor(soldTicketPersistance / 10);
		if (raiseCount < 10) {
			for (int i = 0; i < raiseCount; i++) {
				basePrice = basePrice.add(basePrice.multiply((new BigDecimal(ticketRaisePersistance))));
			}
			airwayFlyingDto.setSellPrice(new BigDecimal(NumberFormat.getInstance().format(basePrice)));
		} else {
			airwayFlyingDto.setSellPrice(BigDecimal.ZERO);
		}
		return airwayFlyingDto;
	}

}
