package com.erhanturkcan.airlineticketsystem.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.erhanturkcan.airlineticketsystem.domain.dto.TicketDTO;
import com.erhanturkcan.airlineticketsystem.enums.ResponseStatus;
import com.erhanturkcan.airlineticketsystem.web.response.BaseResponse;

public class ValidateAndFormatUtil {
	final static int STARTLENGTH = 6;
	final static int ENDLENGTH = 4;

	public static BaseResponse validateCreditCard(TicketDTO ticketDTO) throws Exception {
		BaseResponse baseResponse = new BaseResponse();
		if (ticketDTO != null && ticketDTO.getCreditCard() != null) {
			String cardNumber = ticketDTO.getCreditCard();
			cardNumber = cardNumber.replaceAll("[^a-zA-Z0-9]", "");
			String regex = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(cardNumber);
			if (matcher.matches()) {
				ticketDTO.setCreditCard(maskCardNumber(cardNumber));
			} else {
				baseResponse.setErrorDesc("Wrong Credit Card Number");
				baseResponse.setErrorId(10000L);
				baseResponse.setStatus(ResponseStatus.FAILURE);
			}
		} else {
			baseResponse.setErrorDesc("Enter Credit Card Number");
			baseResponse.setErrorId(10000L);
			baseResponse.setStatus(ResponseStatus.FAILURE);
		}
		return baseResponse;

	}

	public static String maskCardNumber(String cardNumber) {
 
		int maskedLength = cardNumber.length() - (STARTLENGTH + ENDLENGTH);
		System.out.println(maskedLength);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < maskedLength; i++) {
			sb.append("*");
		}
		String maskedCard = cardNumber.substring(0, STARTLENGTH) + sb
				+ cardNumber.substring(cardNumber.length() - ENDLENGTH, cardNumber.length());
		return maskedCard;
	}
}
