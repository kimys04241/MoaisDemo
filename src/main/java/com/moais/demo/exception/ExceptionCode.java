package com.moais.demo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionCode {
	// AuthExcetion
	AUTH_EXCEPTION(403, "AE-000", "Auth Exception"),
	EMPTY_TOKEN_EXCEPTION(403,"AE-001", "Empty Token Exception"),
	ACCESS_DENIED_EXCEPTION(403, "AE-002", "Access Denied Exception"),
	JWT_TOKEN_EMPTY_EXCEPTION(403, "AE-003", "Jwt Token Empty Exception"),
	ACCESS_TOKEN_EXPIRE_EXCEPTION(403, "AE-004", "Access Token Expire Exception"),
	// UserException
	USER_EXCEPTION(400, "UE-000", "USER_EXCEPTION"),
	PASSWORD_NOT_MATCH_EXCEPTION(400, "UE-001", "PASSWORD_NOT_MATCH"),
	USER_ALREADY_EXIST_EXCEPTION(400, "UE-002", "USER_ALREADY_EXIST_EXCEPTION"),
	USER_NOT_FOUND_EXCEPTION(400, "UE-003", "USER_NOT_FOUND_EXCEPTION"),
	// ParamException
	PARAM_EXCEPTION(400, "PE-001", "PARAM_EXCEPTION"),
	// Review
	REVIEW_EXCEPTION(400, "RE-000", "REVIEW_EXCEPTION"),
	REVIEW_ALREADY_EXIST_EXCEPTION(400, "RE-001", "REVIEW_ALREADY_EXIST_EXCEPTION"),
	REVIEW_SCORE_ALREADY_EXIST_EXCEPTION(400, "RE-002", "REVIEW_SCORE_ALREADY_EXIST_EXCEPTION"),
	REVIEW_NOT_EXIST_EXCEPTION(400, "RE-003", "REVIEW_NOT_EXIST_EXCEPTION"),
	REVIEW_SCORE_SHEET_EXCEPTION(400, "RE-004", "RIVEW_SCORE_SHEET_EXCEPTION");
	
	
	
	
	private int statusCode;
	private String errorCode;
	private String errorMessage;
	
	
	private ExceptionCode(int statusCode, String errorCode, String errorMessage) {
		this.statusCode = statusCode;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	

	
}
