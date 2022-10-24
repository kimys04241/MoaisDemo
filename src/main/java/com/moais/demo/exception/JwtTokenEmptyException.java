package com.moais.demo.exception;

public class JwtTokenEmptyException extends AuthException {

	private static final long serialVersionUID = 4548634293667600207L;

	public JwtTokenEmptyException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}

}
