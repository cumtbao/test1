package com.itheima.mapper;

import java.util.List;

import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;

public interface UserMapper {
	//通过id查询
	User findUserById(int i);
	//通过名称模糊查询
	List<User> findUserByUsername(String username);
	//通过对象包装类查询
	List<User> findUserByQueryVo(QueryVo queryVo);
	//查询用户个数
	int findUserCount();
	
	List<User> getUserByResultMap();
	
	List<User> findUserList(User user);
	
	List<User> getUserByDongTai(QueryVo queryVo);
	
}
