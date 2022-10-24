package com.moais.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.moais.demo.auth.jwt.JwtAuthentification;
import com.moais.demo.mapper.UserMapper;
import com.moais.demo.response.TodoResponse;

@Service("todoService")
public class TodoServiceImpl implements TodoService {

	@Autowired
	private UserMapper userMapper;
	

	@Override
	public void writeTodo() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TodoResponse> showTodo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyTodo() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
