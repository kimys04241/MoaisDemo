package com.moais.demo.request;

import javax.validation.constraints.NotEmpty;

import com.moais.demo.dto.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSigninRequest {
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	
	public User toEntity() {
		return User.builder()
				.email(email)
				.password(password)
				.build();
	}
}
