package com.moais.demo.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CodeResponse {
	private String cd;
	private String descKr;
	
	@Builder 
	public CodeResponse(String roomCd, String descKr) {
		this.cd = roomCd;
		this.descKr = descKr;
	}
}
