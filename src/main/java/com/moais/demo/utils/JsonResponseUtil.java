package com.moais.demo.utils;

import org.json.simple.JSONObject;

public class JsonResponseUtil {
	private static String codePrefix="code";
	private static String successCode = "200";
	
	public static JSONObject successReponse() {
		JSONObject obj = new JSONObject();
		obj.put(codePrefix,successCode);
		return obj;
	}

	
	public static <T> String successReponse(T data) {
		
		return "";
	}

	public static String errorLogin(String code, String msg) {
		return errorLogin(code,code);
	}
}
