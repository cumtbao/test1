package com.itheima.dao;

import java.util.List;

import com.itheima.pojo.User;

public interface UserDao {
	
	User getUserById(Integer id);
	
	List<User> getUserByUsername(String Username);
	
	void add(User user);
	
	
}
