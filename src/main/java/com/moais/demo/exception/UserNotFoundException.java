package com.moais.demo.exception;

public class UserNotFoundException extends UserException {

	private static final long serialVersionUID = 8630222736695985488L;

	public UserNotFoundException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}

}
