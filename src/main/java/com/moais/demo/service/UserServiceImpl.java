package com.moais.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.moais.demo.auth.jwt.JwtAuthentification;
import com.moais.demo.dto.User;
import com.moais.demo.exception.ExceptionCode;
import com.moais.demo.exception.UserNotFoundException;
import com.moais.demo.mapper.UserMapper;
import com.moais.demo.response.UserSigninResponse;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private JwtAuthentification jwtAuthentification;
	
	@Transactional
	@Override
	public void signupUser(User user) throws Exception {
		user.passwordMatch(); 
		String checkEmail = userMapper.selectUserByEmail(user.getEmail());
		user.checkAlreadyExist(checkEmail);
		user.userIdGenerate();
		userMapper.insertUser(user);
		
	}

	@Override
	public UserSigninResponse signinUser(User user) throws Exception {
		String userId = userMapper.selectUserByEmailPassword(user.getEmail(), user.getPassword());
		if(!StringUtils.hasText(userId))
			throw new UserNotFoundException(ExceptionCode.USER_NOT_FOUND_EXCEPTION);
		Map<String, String> tokens = jwtAuthentification.makeAllToekn(userId);
		String accessToken = tokens.get(jwtAuthentification.prefixAccessToken);
		String refreshToken = tokens.get(jwtAuthentification.prefixRefresToken);
		System.out.println(accessToken);
		System.out.println(refreshToken);
		redisTemplate.opsForValue().set(jwtAuthentification.prefixAccessToken+":"+userId, accessToken);
		redisTemplate.opsForValue().set(jwtAuthentification.prefixRefresToken+":"+userId, refreshToken);
		
						
		return UserSigninResponse.builder()
								 .accessToken(accessToken)
								 .refreshToken(refreshToken)
								 .build();
	}
}
