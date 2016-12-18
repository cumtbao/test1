package com.itheima.mapper;

import java.util.List;

import com.itheima.pojo.Orders;
import com.itheima.pojo.OrdersUser;
import com.itheima.pojo.User;

public interface OrdersMapper {
	
	List<OrdersUser> getOrdersByUser();
	
	List<Orders> getOrdersByUserResultMap();
	
	List<User> getUserByOrders();
}
