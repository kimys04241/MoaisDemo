package com.moais.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.moais.demo.dto.User;

@Mapper
public interface UserMapper {
	public String selectUserByEmail(String email);
	public String selectUserByEmailPassword(String email, String password);
	public void insertUser(User user);
	public int selectUserByUserId(String userId);
	
}
