package com.moais.demo.exception;

public class ParamException extends MoaisException {

	private static final long serialVersionUID = 3104861869830043612L;

	public ParamException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}

}
