package com.moais.demo.exception;

public class AuthException extends MoaisException {

	private static final long serialVersionUID = 2246958217750487011L;

	public AuthException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}

}
