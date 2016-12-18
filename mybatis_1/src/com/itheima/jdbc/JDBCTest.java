package com.itheima.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获得驱动管理类获得数据库的连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?charset=utf-8", "root",
					"123");
			//sql语句
			String sql ="select * from user where username like ?";
			 ps = connection.prepareStatement(sql);
			 ps.setString(1, "%王%");
			 rs=ps.executeQuery();
			 while(rs.next()){
				 System.out.println(rs.getString("id")+"-------"+rs.getString("username"));
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
