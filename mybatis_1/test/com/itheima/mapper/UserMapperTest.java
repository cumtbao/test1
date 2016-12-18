package com.itheima.mapper;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;

public class UserMapperTest {
	
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		
	}
	
	@Test
	public void testFindUserById() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(33);
		System.out.println(user);
	}

	@Test
	public void testFindUserByUsername() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//List<User> list = userMapper.findUserByUsername("明");
		List<User> list = userMapper.findUserByUsername("小");
		for(User u:list){
			System.out.println(u);
		}
	}
	
	@Test
	public void testFindUserByQueryVo(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		User user = new User();
		user.setUsername("小");
		queryVo.setUser(user);
		List<User> list = userMapper.findUserByQueryVo(queryVo);
		System.out.println(list);
		
		sqlSession.close();
	}
	//查询所有用户的个数
	@Test
	public void testFindUserCount(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		int count = userMapper.findUserCount();
		System.out.println(count);
		sqlSession.close();
	
	}
	
	@Test
	public void testGetUserByResultMap(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.getUserByResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindUserList(){
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(1);
		user.setUsername("小");
		List<User> list = userMapper.findUserList(user);
		System.out.println(list);
	}
	@Test
	public void testGetUserByDongTai(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		Integer[] ids = {22,23,25};
		User user = new User();
		user.setUsername("小");
		queryVo.setUser(user);
		queryVo.setIds(ids);
		List<User> list = userMapper.getUserByDongTai(queryVo);
		System.out.println(list);
		
	}
}
