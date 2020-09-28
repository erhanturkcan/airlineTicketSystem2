package com.erhanturkcan.airlineticketsystem.web.response;

import com.erhanturkcan.airlineticketsystem.enums.ResponseStatus;

public class BaseResponse {
	
	private ResponseStatus status = ResponseStatus.SUCCESS;
	private Long errorId;
	private String errorDesc;
	public ResponseStatus getStatus() {
		return status;
	}
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	public Long getErrorId() {
		return errorId;
	}
	public void setErrorId(Long errorId) {
		this.errorId = errorId;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	} 

}
