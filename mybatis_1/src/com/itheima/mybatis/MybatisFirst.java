package com.itheima.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.pojo.User;

public class MybatisFirst {
	
	//根据id查询用户
	@Test
	public void getUserById() throws IOException {
		
		//加载配置文件，创建sqlSessionFactory
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		 
		
		SqlSessionFactory sessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		//获取数据库会话实例
		SqlSession session = sessionFactory.openSession();
			
		User user = session.selectOne("test.findUserById", 10);
		System.out.println(user.getUsername());
		
		session.close();
						
	}
	
	//根据用户名模糊查询
	@Test
	public void findUserByUsername(){
		SqlSession sqlSession =null;
		//读取配置文件，获取工厂类
		try {
			SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
			
			sqlSession = sessionFactory.openSession();
			
			//List<User> list = sqlSession.selectList("findUserByUsername", "%王%");
			List<User> list =sqlSession.selectList("test.findUserByUsername", "小");
			
			for(User u:list){
				System.out.println(u.getUsername());
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	//插入新用户
	@Test
	public void testInsert() throws IOException{
		//读取配置文件
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		SqlSession session = sqlSessionFactory.openSession();
		//创建用户
		User user = new User();
		user.setUsername("贾静雯33");
		user.setSex("2");
		user.setAddress("南京");
		
		session.insert("insertUser", user);
		
		System.out.println(user.getId());
		//事务的提交
		session.commit();
		session.close();
		
	}
	
	//更新用户
	@Test
	public void  testUpdate() throws IOException{
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory sessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		
		SqlSession sqlSession = sessionFactory.openSession();
		//创建用户
		User user = new User();
		user.setId(33);
		user.setUsername("姚明");
		user.setSex("1");
		user.setAddress("上海");
		
		sqlSession.update("updateUser", user);
		
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	//删除用户
	@Test
	public void testDelete() throws IOException{
		
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("deleteUser", 32);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
}
