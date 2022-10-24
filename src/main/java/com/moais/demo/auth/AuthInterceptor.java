package com.moais.demo.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.moais.demo.auth.jwt.JwtAuthentification;
import com.moais.demo.dto.User;
import com.moais.demo.exception.AccessDeniedException;
import com.moais.demo.exception.ExceptionCode;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtAuthentification jwtAuthentification;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private String authHeader = "Authorization";
	private String prefixRequestUser = "user";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod == false) {
			return true;
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		RoleChecker auth = handlerMethod.getMethodAnnotation(RoleChecker.class);

		double role = 0;
		if (auth != null && auth.role() != null) {
			role = auth.role().getValue();
		}

		if (role == 0)
			return true;
		
		User user = null;
		String jwt = request.getHeader(authHeader);
		user = jwtAuthentification.getLoginInfo(jwt);
		String redisAccess = (String) redisTemplate.opsForValue().get(jwtAuthentification.prefixAccessToken+":"+user.getUserId());
		System.out.println("jwt   : " + jwt  );
		System.out.println("redis : " + redisAccess);
		
		if(StringUtils.hasText(jwt) && !jwt.equals(redisAccess))
			throw new AccessDeniedException(ExceptionCode.ACCESS_DENIED_EXCEPTION);
		if (role > 0) {
			if (user == null || !StringUtils.hasText(user.getUserId()))
				throw new AccessDeniedException(ExceptionCode.ACCESS_DENIED_EXCEPTION);
		}
		request.setAttribute(prefixRequestUser, user);
		
		return true;
	}

}