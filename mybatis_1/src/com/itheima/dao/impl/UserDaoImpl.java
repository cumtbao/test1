package com.itheima.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

public class UserDaoImpl implements UserDao {
	//工厂对象，单例方式存在
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("findUserById", id);
		return user;
	}

	@Override
	public List<User> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("findUserByUsername", username);
		return list;
	}


	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

}
