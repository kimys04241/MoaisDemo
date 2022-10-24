package com.moais.demo.dto;

import org.springframework.util.StringUtils;

import com.moais.demo.exception.ExceptionCode;
import com.moais.demo.exception.PasswordNotMatchException;
import com.moais.demo.exception.UserAlreadyExistException;
import com.moais.demo.exception.UserException;
import com.moais.demo.utils.PrimaryKeyGenerator;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
	private String userId;
	private String email;
	private String password;
	private String checkPassword;
	
	@Builder
	public User(String userId, String email, String password, String checkPassword) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.checkPassword = checkPassword;
	}
	
	public void passwordMatch() throws Exception {
		if(StringUtils.hasText(password) && !password.equals(checkPassword))
			throw new PasswordNotMatchException(ExceptionCode.PASSWORD_NOT_MATCH_EXCEPTION);
	}
	
	public void checkAlreadyExist(String checkEmail) throws UserException {
		if(StringUtils.hasText(checkEmail) && checkEmail.equals(this.email))
			throw new UserAlreadyExistException(ExceptionCode.USER_ALREADY_EXIST_EXCEPTION);
		
	}
	
	public void userIdGenerate() {
		this.userId = PrimaryKeyGenerator.next();
	}
}

