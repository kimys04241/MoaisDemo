package com.moais.demo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExceptionResponse {
	private String errorCode;
	private String errorMessage;
	
	@Builder
	public ExceptionResponse(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
