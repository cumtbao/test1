package com.itheima.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.pojo.User;

public class UserDaoTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException{
		sqlSessionFactory= new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		
	}
	
	@Test
	public void testGetUserById(){
		
		UserDao userDao=new UserDaoImpl(sqlSessionFactory);
		User user = userDao.getUserById(30);
		System.out.println(user);
	}
	
	@Test
	public void testGetUserByUsername(){
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> list = userDao.getUserByUsername("小");
		for(User u:list){
			System.out.println(u);
		}
		
	}
}
