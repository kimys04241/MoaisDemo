package com.moais.demo.exception;

public class MoaisException extends Exception {

	private static final long serialVersionUID = 2650457082082168308L;
	
	
	private ExceptionCode exceptionCode;
	
	public MoaisException(ExceptionCode exceptionCode) {
		super(exceptionCode.getErrorMessage());
		this.exceptionCode = exceptionCode;
	}
	
	public int getStatusCode() {
		return exceptionCode.getStatusCode();
	}
	
	public String getErrorCode() {
		return exceptionCode.getErrorCode();
	}
	public String getErrorMessage() {
		return exceptionCode.getErrorMessage();
	}
}
