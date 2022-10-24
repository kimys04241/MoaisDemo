package com.moais.demo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserSigninResponse {
	private String accessToken;
	private String refreshToken;
	
	@Builder
	public UserSigninResponse(String accessToken, String refreshToken) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}
}
