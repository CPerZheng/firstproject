package com.oddjob.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectManager {

	//数据库链接
	private Connection connection = null;
	
	/**
	 * 获取数据库链接传统jdbc
	 */
	
	public Connection getConnection_jdbc() {
		
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.链接数据库
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ttlg?useUnicode=true&characterEncoding=utf-8", "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//返回参数
		return connection;
	}
	
	/**
	 * 获取数据库链接jndi
	 */
	
	public Connection getConnection_jndi() {
		
		try {
			//通过数据源获取数据库连接
			//通过JNDI接口查询名称叫做tjndi服务
			//建立上下文
			Context cxt = new InitialContext();
			//调用lookup方法查找配置的服务(数据源)
			DataSource source = (DataSource) cxt.lookup("java:comp/env/jdbc/news");
			
			//通过数据源获取数据库链接
			connection = source.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//返回数据库链接
		return connection;
	}
	
	//关闭数据库链接
	public void closeConnection() {
		
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
