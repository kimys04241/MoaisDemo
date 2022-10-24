package com.moais.demo.auth.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.moais.demo.dto.User;
import com.moais.demo.exception.AccessTokenExpireException;
import com.moais.demo.exception.ExceptionCode;
import com.moais.demo.exception.JwtTokenEmptyException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtAuthentification {
	
	@Value("${jwt.secret.access}")
	private String secretKeyAccess;
	@Value("${jwt.secret.refresh}")
	private String secretKeyRefresh;
	@Value("${jwt.expire.access}")
	private long expireAccess;
	@Value("${jwt.expire.refresh}")
	private long expireRefresh;
	@Value("${jwt.prefix.access}")
	public String prefixAccessToken;
	@Value("${jwt.prefix.refresh}")
	public String prefixRefresToken;
	@Value("${jwt.enc.secret}")
	private String userEncSecretKey;;
	@Value("${jwt.enc.iv}")
	private String userEncSecretIv;
	
	private String encType = "UTF-8";
	private String algorithm = "AES";
	private String transformation = "AES/CBC/PKCS5Padding";
	
	public Map<String,String> makeAllToekn(String userId) throws Exception {
		Map<String,String> tokens = new HashMap<String, String>();
		tokens.put(prefixAccessToken, makeToken(userId, expireAccess, secretKeyAccess));
		tokens.put(prefixRefresToken, makeToken(userId, expireRefresh, secretKeyRefresh));
		return tokens;
	}
	
	private String makeToken(String userId, long sec, String keyData) throws Exception {
		if(!StringUtils.hasText(userId)) throw new Exception();
		
		Date expireDate = new Date(System.currentTimeMillis()+sec);
		
		String jwt = Jwts.builder()
				  .setSubject(encrypt(userId))
				  .setExpiration(expireDate)
				  .signWith(
				    SignatureAlgorithm.HS256,
				    keyData.getBytes(encType)
				  ).compact();
		return jwt;
	}
	

	public User getLoginInfo(String token) throws Exception{
		return getLoginInfo(token, secretKeyAccess);
	}
	
	private User getLoginInfo(String token, String secret) throws Exception{
		if(!StringUtils.hasText(token)) {
			throw new JwtTokenEmptyException(ExceptionCode.JWT_TOKEN_EMPTY_EXCEPTION);
		}
		
		Jws<Claims> claims = Jwts.parser().setSigningKey(secret.getBytes(encType))
				  .parseClaimsJws(token);
		Date expireDate = claims.getBody().getExpiration();
		if(expireDate.before(new Date(System.currentTimeMillis()))) 
			throw new AccessTokenExpireException(ExceptionCode.ACCESS_TOKEN_EXPIRE_EXCEPTION);
		
		String userInfo = claims.getBody().getSubject();
		String userId = decrypt(userInfo);
		System.out.println("userId : " + userId);
		User user = User.builder().userId(userId).build();
		return user;
	}
	
	
	private String encrypt(String msg) throws Exception{
		String result = null;
		try{
		   SecretKey key = new SecretKeySpec(userEncSecretKey.getBytes(), algorithm);
		   IvParameterSpec iv = new IvParameterSpec(userEncSecretIv.getBytes());
		   Cipher clsCipher = Cipher.getInstance(transformation);
		   clsCipher.init( Cipher.ENCRYPT_MODE, key, iv );
		   byte [] enc = clsCipher.doFinal(msg.getBytes(encType));
		   result = new String(Base64.getEncoder().encode(enc));
		}catch( Exception e ){ 
		   e.printStackTrace();
		 }
		return result;
	}
	
	

	private String decrypt(String msg) throws Exception{
		String result = null;
		try{
		   SecretKey key = new SecretKeySpec( userEncSecretKey.getBytes(), algorithm );
		   IvParameterSpec iv = new IvParameterSpec( userEncSecretIv.getBytes() );
		   Cipher clsCipher = Cipher.getInstance(transformation);
		   clsCipher.init( Cipher.DECRYPT_MODE, key, iv );
		   byte [] arrDec = clsCipher.doFinal(Base64.getDecoder().decode(msg) );
		   result =  new String(arrDec);
		 }catch( Exception e ){
		   e.printStackTrace();
		 }
		return result;
	}
	
}
