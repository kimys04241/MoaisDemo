package com.moais.demo.service;

import java.util.List;

import com.moais.demo.response.TodoResponse;

public interface TodoService {
	
	public void writeTodo() throws Exception;
	public List<TodoResponse> showTodo() throws Exception;
	public void modifyTodo() throws Exception;
}
