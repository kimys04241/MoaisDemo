package com.moais.demo.exception;

public class EmptyTokenException extends AuthException {

	private static final long serialVersionUID = 1664396723228771364L;

	public EmptyTokenException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}

}
