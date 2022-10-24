package com.moais.demo.exception;

public class UserException extends MoaisException {

	private static final long serialVersionUID = 4284210868515049503L;

	public UserException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}

}
