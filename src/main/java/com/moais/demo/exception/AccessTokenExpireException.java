package com.moais.demo.exception;

public class AccessTokenExpireException extends AuthException {

	private static final long serialVersionUID = 9098929811410536708L;

	public AccessTokenExpireException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}

}
