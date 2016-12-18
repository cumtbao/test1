package com.itheima.mapper;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.pojo.Orders;
import com.itheima.pojo.OrdersUser;
import com.itheima.pojo.User;

public class OrdersMapperTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException{
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("SqlMapConfig.xml"));
	}
	
	
	@Test
	public void testGetOrdersByUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		
		List<OrdersUser> list = ordersMapper.getOrdersByUser();
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void getOrdersByUserResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		
		List<Orders> list = ordersMapper.getOrdersByUserResultMap();
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void getUserByOrders(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		
		List<User> list = ordersMapper.getUserByOrders();
		System.out.println(list);
		sqlSession.close();
	}

}
