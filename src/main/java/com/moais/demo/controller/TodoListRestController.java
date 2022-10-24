package com.moais.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moais.demo.auth.RoleChecker;
import com.moais.demo.auth.RoleChecker.Role;
import com.moais.demo.request.UserSigninRequest;
import com.moais.demo.request.UserSignupRequest;
import com.moais.demo.service.TodoService;
import com.moais.demo.service.UserService;
import com.moais.demo.utils.JsonResponseUtil;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoListRestController {
	
	@Autowired
	private TodoService todoService;
	
	@RoleChecker(role = Role.NONE)
	@PutMapping(value = "/write")
	@ResponseBody
	public Object writeTodoList(HttpServletRequest request, @Validated @RequestBody UserSignupRequest param) throws Exception {
		todoService.writeTodo();
		return JsonResponseUtil.successReponse();
	}
	
	@PostMapping(value = "/list")
	@ResponseBody
	public Object showTodoList(HttpServletRequest request, @RequestBody UserSigninRequest param) throws Exception {
		return todoService.showTodo();
	}
	
	@PostMapping(value = "/modify")
	@ResponseBody
	public Object modifyTodoList(HttpServletRequest request, @RequestBody UserSigninRequest param) throws Exception {
		todoService.modifyTodo();
		return JsonResponseUtil.successReponse();
	}
	
}
