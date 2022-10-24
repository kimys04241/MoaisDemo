package com.moais.demo.exception;

public class AccessDeniedException extends AuthException {

	private static final long serialVersionUID = -148774341452562973L;

	public AccessDeniedException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}



}
