package com.oddjob.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oddjob.entity.Admin;
import com.oddjob.idao.IAdminDao;

public class AdminDao implements IAdminDao {

	// 建立数据库链接
	private ConnectManager cm = new ConnectManager();

	/**
	 * 管理员登录方法
	 */
	@Override
	public Admin login(String zh, String pwd) {

		// 返回值
		Admin admin = null;

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from admin where zh='"+zh+"' and pwd='"+pwd+"'";
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);

			// 判断是否有此管理员
			while (rs.next()) {
				// 有此管理员
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setZh(rs.getString("zh"));
				admin.setPwd(rs.getString("pwd"));
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
		return admin;
	}

	/**
	 * 增加管理员
	 */
	@Override
	public int addAdmin(Admin admin) {
		// 返回值
		int num = 0;

		// 获取数据库链接
		Connection con = null;

		try {
			// 1.获取数据库链接
			con = cm.getConnection_jdbc();
			// 2.建立sql语句
			String sql = "insert into admins(id,zh,pwd) values('"
					+ admin.getId() + "','" + admin.getZh() + "','"
					+ admin.getPwd() + "')";
			// 3.建立sql执行对象
			Statement stm = con.createStatement();
			// 4.执行sql,返回结果
			num = stm.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库链接
			cm.closeConnection();
		}
		return 0;
	}
	

	/**
	 * 修改管理员
	 */
	@Override
	public int updateAdmin(Admin admin) {
		// 返回值
		int num = 0;

		// 获取数据库链接
		Connection con = null;

		try {
			// 1.获取数据库链接
			con = cm.getConnection_jdbc();
			// 2.建立sql语句
			String sql = "update admins set zh='" + admin.getZh() + "','"
					+ admin.getPwd() + "' where id=" + admin.getId();
			// 3.建立sql语句执行对象
			Statement stm = con.createStatement();
			// 4.执行sql,返回查询结果
			num = stm.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库链接
			cm.closeConnection();
		}
		return num;
	}

	/**
	 * 删除管理员
	 */
	@Override
	public int delAdmin(int id) {
		// 返回值
		int num = 0;
		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "delete from admin where id=" + id;
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			num = stm.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库链接
			cm.closeConnection();
		}
		return num;
	}

	/*
	 * 获取管理员列表参数：pageNo - 当前页，pageSize - 每页记录数，keyword - 查询字段(non-Javadoc)
	 * 返回值：Map
	 * (pageNo-当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
	 * 
	 * @see com.oddjob.idao.IAdminDao#getAdminItem(java.lang.String)
	 */
	@Override
	public List getAdminItem(String zh) {

		// 返回值
		List list = null;

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from admins where name like '%" + zh + "%' ";
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);
			// 取出查询出来的管理员列表
			while (rs.next()) {
				// 新建管理员列表
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setPwd(rs.getString("pwd"));
				admin.setZh(rs.getString("zh"));

				// 存储到list中
				list.add(admin);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库
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

	/*
	 * 根据管理员编号获取管理员(non-Javadoc) 参数:id
	 * @see com.oddjob.idao.IAdminDao#getAdminById(java.lang.String)
	 */
	@Override
	public Admin getAdminById(String id) {

		// 返回值
		Admin admin = null;

		// 获取数据库链接
		Connection con = null;
		// 获取数据库链接
		con = cm.getConnection_jdbc();
		try {
			// 建立sql语句
			String sql = "select * from admins where id=" + id;
			// 建立sql语句 执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);

			// 获取查询出来的数据
			while (rs.next()) {
				// 新建管理员对象
				admin = new Admin();

				admin.setId(rs.getInt("id"));
				admin.setZh(rs.getString("zh"));
				admin.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库
			cm.closeConnection();
		}

		return admin;
	}

	@Override
	public Map getAdminByPages(int pageNo, int pageSize, String keywords3) {

		// 返回值
		Map map = new HashMap();
		//分页数据
		List list = new ArrayList();

		try {
			// 获取数据库链接
			Connection con = null;
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			//1.建立sql语句(查询总记录数,查询总页数)
			String sql = "select count(*) as totalRecords from admins where name like'%"+keywords3+"%'";
			//创建查询对象
			Statement stm = con.createStatement();
			//执行操作对象
			ResultSet rs = stm.executeQuery(sql);
			
			//获取总记录数
			int totalRecords = 0;
			if(rs.next()) {
				totalRecords = rs.getInt("totalRecords");
			}
			
			//计算总页数
			int totalPages = 0;
			if(totalRecords % pageSize == 0) {
				totalPages = totalRecords / pageSize;
			} else {
				totalPages = totalRecords / pageSize + 1;
			}
			
			//2.查询分页数
			//计算分页索引
			int index = (pageNo - 1) * pageSize;
			sql = "select * from admins where name like '"+keywords3+"' limit "+index+"," + pageSize;
			
			//创建sql执行对象
			Statement stm_1 = con.createStatement();
			//执行sql语句
			ResultSet rs_1 = stm.executeQuery(sql);
			//获取分页数据
			while(rs_1.next()) {
				//新建管理员对象
				Admin admin = new Admin();
				admin.setId(rs_1.getInt("id"));
				admin.setZh(rs_1.getString("zh"));
				admin.setPwd(rs_1.getString("pwd"));
				
				//储存在list
				list.add(admin);
			}
			
			//封装返回的map对象
			//Map(pageNo-当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
			map.put("pageNo", pageNo);
			map.put("pageSize", pageSize);
			map.put("totalPages", totalPages);
			map.put("totalRecords", totalRecords);
			map.put("data", list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭数据库链接
			cm.closeConnection();
		}
		//返回分页结果
		return map;
	}

}
