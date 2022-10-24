package com.moais.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moais.demo.exception.AuthException;
import com.moais.demo.exception.MoaisException;
import com.moais.demo.exception.UserException;
import com.moais.demo.response.ExceptionResponse;

import io.jsonwebtoken.SignatureException;

@ControllerAdvice
public class ControllerAdvisor {
	
//	@ExceptionHandler( value = Exception.class)
//	@ResponseBody 
//	public ResponseEntity<ExceptionResponse> handlerException(Exception e, HttpServletResponse response) {
//		return ResponseEntity
//				.status(HttpStatus.INTERNAL_SERVER_ERROR)
//				.body(ExceptionResponse.builder()
//						.errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
//						.errorMessage(e.getMessage())
//						.build());
//	}
	
	@ExceptionHandler( value = MethodArgumentNotValidException.class)
	@ResponseBody 
	public ResponseEntity<ExceptionResponse> handlerVaildException(Exception e, HttpServletResponse response) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ExceptionResponse.builder()
						.errorCode(HttpStatus.BAD_REQUEST.toString())
						.errorMessage("Missing required values")
						.build());
	}
	
	@ExceptionHandler( value = MissingServletRequestParameterException.class)
	@ResponseBody 
	public ResponseEntity<ExceptionResponse> handlerReqParamException(Exception e, HttpServletResponse response) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ExceptionResponse.builder()
						.errorCode(HttpStatus.BAD_REQUEST.toString())
						.errorMessage("Missing required values")
						.build());
	}
	
	@ExceptionHandler( value = MoaisException.class)
	@ResponseBody 
	public ResponseEntity<ExceptionResponse> handlerDabangException(MoaisException e, HttpServletResponse response) {
		return ResponseEntity
				.status(e.getStatusCode())
				.body(ExceptionResponse.builder()
						.errorCode(e.getErrorCode())
						.errorMessage(e.getErrorMessage())
						.build());
	}
	
	@ExceptionHandler( value = AuthException.class)
	@ResponseBody 
	public ResponseEntity<ExceptionResponse> handlerLoginException(AuthException e, HttpServletResponse response) {
		return ResponseEntity
				.status(e.getStatusCode())
				.body(ExceptionResponse.builder()
						.errorCode(e.getErrorCode())
						.errorMessage(e.getErrorMessage())
						.build());
	}
	
	@ExceptionHandler( value = UserException.class)
	@ResponseBody 
	public ResponseEntity<ExceptionResponse> handlerUserException(UserException e, HttpServletResponse response) {
		return ResponseEntity
				.status(e.getStatusCode())
				.body(ExceptionResponse.builder()
						.errorCode(e.getErrorCode())
						.errorMessage(e.getErrorMessage())
						.build());
	}
	
	@ExceptionHandler( value = SignatureException.class)
	@ResponseBody 
	public ResponseEntity<ExceptionResponse> handlerUserException(SignatureException e, HttpServletResponse response) {
		return ResponseEntity
				.status(HttpStatus.UNAUTHORIZED)
				.body(ExceptionResponse.builder()
						.errorCode("403")
						.errorMessage("bad request")
						.build());
	}
	
}
