package com.oddjob.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oddjob.entity.Order;
import com.oddjob.entity.OrderItem;
import com.oddjob.idao.IOrderDao;

public class OrderDao implements IOrderDao {

	// 建立数据库链接
	private ConnectManager cm = new ConnectManager();

	/**
	 * 根据订单编号查询订单
	 */
	@Override
	public Order getOrderById(int id) {

		// 返回值
		Order order = null;
		// 获取数据库链接
		Connection con = null;

		try {
			// 建立sql语句
			String sql = "select * from o.*,u.name as uname from users u,orders o where u.id = o.u_id and o.id ="
					+ id;
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);

			// 获取查询出来的数据
			if (rs.next()) {
				// 新建对象
				order = new Order();

				order.setId(rs.getInt("id"));
				order.setName(rs.getString("name"));
				order.setImg(rs.getString("img"));
				order.setsTime(rs.getString("sTime"));
				order.setdTime(rs.getString("sTime"));
				order.setPhone(rs.getString("phone"));
				order.setName(rs.getString("name"));
				order.setPe_num(rs.getInt("pe_num"));
				order.setPrice(rs.getDouble("price"));
				order.setType_name(rs.getString("type_name"));
				order.setAdress(rs.getString("address"));
				order.setContent(rs.getString("content"));
				order.setState(rs.getInt("state"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库链接
			cm.closeConnection();
		}

		return order;
	}

	/**
	 * 根据订单名称查询订单
	 */
	@Override
	public List getOrderByName(String name) {
		// 返回值
		List list = new ArrayList();

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from orders where name like '%" + name
					+ "%'";
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);

			// 将查询结果取出来
			while (rs.next()) {

				// 新建订单对象
				Order order = new Order();

				order.setId(rs.getInt("id"));
				order.setName(rs.getString("name"));
				order.setImg(rs.getString("img"));
				order.setsTime(rs.getString("sTime"));
				order.setdTime(rs.getString("sTime"));
				order.setPhone(rs.getString("phone"));
				order.setName(rs.getString("name"));
				order.setPe_num(rs.getInt("pe_num"));
				order.setPrice(rs.getDouble("price"));
				order.setType_name(rs.getString("type_name"));
				order.setAdress(rs.getString("address"));
				order.setContent(rs.getString("content"));
				order.setState(rs.getInt("state"));

				list.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 返回值
		return list;
	}

	/**
	 * 根据订单编号,查询订单详细信息
	 */
	@Override
	public List getOrderItem(String id) {

		// 返回值
		List list = new ArrayList();

		// 获取数据库链接
		Connection con = null;

		try {
			con = cm.getConnection_jdbc();
			// 获取数据库链接
			String sql = "select * from orderitem where id= " + id;
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);
			// 取出查询出来的列表
			while (rs.next()) {
				// 新建对象
				OrderItem oitem = new OrderItem();

				oitem.setId(rs.getInt("id"));
				oitem.setU_id(rs.getInt("u_id"));
				oitem.setO_id(rs.getInt("o_id"));
				oitem.setImg(rs.getString("img"));
				oitem.setlName(rs.getString("lName"));
				oitem.setPrice(rs.getDouble("price"));
				oitem.setAddress(rs.getString("address"));
				oitem.setsTime(rs.getString("sTime"));
				oitem.setState(rs.getInt("state"));

				// 存储到list中
				list.add(oitem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 修改订单状态
	 */
	@Override
	public int updateOrder(Order order, int op) {
		// 返回值
		int num = 0;
		// 获取数据库链接
		Connection con = null;

		// 1.获取数据库链接
		con = cm.getConnection_jdbc();
		// 2.建立sql语句
		String sql = "update orders set state =" + order.getState()
				+ "where id=" + order.getId();
		if (op != 1) {
			sql = "";
		}
		return num;
	}

	@Override
	public List getOrderByUid(String u_staffId) {
		// 返回值
		List list = new ArrayList();

		// 获取数据库链接
		Connection con = null;
		try {
			//获取数据库链接
			con = cm.getConnection_jdbc();
			// 获取数据库链接
			String sql = "select * from orders where u_staffId= " + u_staffId;
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);
			// 取出查询出来的列表
			while (rs.next()) {
				// 新建对象
				Order order = new Order();

				order.setId(rs.getInt("id"));
				order.setU_bossId(rs.getInt("u_bossId"));
				order.setU_staffId(rs.getInt("u_staffId"));
				order.setName(rs.getString("name"));
				order.setImg(rs.getString("img"));
				order.setsTime(rs.getString("sTime"));
				order.setdTime(rs.getString("dTime"));
				order.setPhone(rs.getString("phone"));
				order.setP_name(rs.getString("p_name"));
				order.setPe_num(rs.getInt("pe_num"));
				order.setPrice(rs.getDouble("price"));
				order.setType_name(rs.getString("type_name"));
				order.setAdress(rs.getString("address"));
				order.setContent(rs.getString("content"));
				order.setState(rs.getInt("state"));

				// 存储到list中
				list.add(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public int addOrder(Order order, List olist) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delOrder(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map getOrderPages(int pageNo, int pageSize, String keyword1,
			String keyword2) {
		// TODO Auto-generated method stub
		return null;
	}

}
