package com.oddjob.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oddjob.entity.WorkType;
import com.oddjob.idao.IWorkTypeDao;

public class WorkTypeDao implements IWorkTypeDao {

	// 创建数据库链接管理类
	private ConnectManager cm = new ConnectManager();

	/**
	 * 根据零工类目名称查询类目
	 */
	@Override
	public List getWorkByName(String name) {
		// 返回值
		List list = new ArrayList();

		// 获取数据库连接
		Connection con = null;

		try {
			// 1.获取数据库连接
			con = cm.getConnection_jdbc();
			// 2.建立sql语句
			String sql = "select * from worktype where name like '%" + name
					+ "%'";
			// 3.建立Sql语句的执行对象
			Statement stm = con.createStatement();
			// 4.执行sql语句
			ResultSet rs = stm.executeQuery(sql);
			// 5.取出查询出来的类目列表
			while (rs.next()) {
				// 新建商品类目对象
				WorkType type = new WorkType();
				type.setId(rs.getInt("id"));
				type.setName(rs.getString("name"));

				// 存储在List中
				list.add(type);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// 返回
		return list;
	}

	/**
	 * 根据零工类目编号查询零工类目
	 */
	@Override
	public WorkType getWorkById(String id) {

		// 返回值
		WorkType worktype = new WorkType();

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from worktype where id=" + id;
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);

			// 取出查询出来的数据
			if (rs.next()) {
				// 新建商品类目对象
				worktype = new WorkType();
				worktype.setId(rs.getInt("id"));
				worktype.setName(rs.getString("name"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库
			cm.closeConnection();
		}
		return worktype;
	}

	/**
	 * 修改零工类目
	 */
	@Override
	public int updateWork(WorkType wtype) {

		// 返回值
		int num = 0;

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "update worktype set name='" + wtype.getName()
					+ "' where id=" + wtype.getId();
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句,返回执行结果
			num = stm.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库
			cm.closeConnection();
		}
		// 返回值
		return num;
	}

	/**
	 * 增加零工类目
	 */
	@Override
	public int addWork(WorkType wtype) {

		// 返回值
		int num = 0;

		// 获取数据库链接
		Connection con = null;
		try {
			//获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "insert into worktype(name) values('"
					+ wtype.getName() + "')";
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句并返回查询结果
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
	 * 根据零工类目编号删除零工类目
	 */
	@Override
	public int delWork(int id) {

		// 返回值
		int num = 0;

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "delete from worktype where id=" + id;
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句并返回查询结果
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
	 * 获取零工类目列表，分页显示 参数：pageNo - 当前页，pageSize - 每页记录数，keyword - 查询字段
	 * 返回值：Map(pageNo
	 * -当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
	 */
	@Override
	public Map getWorkTypePages(int pageNo, int pageSize, String keyword) {

		// 返回值
		Map map = new HashMap();
		// 分页数据
		List list = new ArrayList();

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 新建sql语句
			String sql = "select count(*) as totalRecords from worktype where name like '%"+keyword+"%'";
			// 新建sql语句执行对象
			Statement stm = con.createStatement();
			// 执行查询操作
			ResultSet rs = stm.executeQuery(sql);

			// 1.获取总记录数
			int totalRecords = 0;
			if (rs.next()) {
				totalRecords = rs.getInt("totalRecords");
			}

			// 2.计算总页数
			int totalPages = 0;
			if (totalRecords % pageSize == 0) {
				totalPages = totalRecords / pageSize;
			} else {
				totalPages = totalRecords / pageSize + 1;
			}

			// 3.查询分页数据
			// 计算分页索引(数据总数/每页记录数)
			int index = (pageNo - 1) * pageSize;
			
			sql = "select * from worktype where name like '%"+keyword+"%' limit " +index+ "," +pageSize;
			// 创建sql语句执行对象
			Statement stm_1 = con.createStatement();
			// 执行查询操作
			ResultSet rs_1 = stm_1.executeQuery(sql);

			// 取出分页数据
			while (rs_1.next()) {
				// 新建零工类目对象
				WorkType wtype = new WorkType();

				wtype.setId(rs_1.getInt("id"));
				wtype.setName(rs_1.getString("name"));

				// 存储在list
				list.add(wtype);
			}

			// 封装返回的Map对象
			// 返回值：Map(pageNo-当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
			map.put("pageNo", pageNo);
			map.put("pageSize", pageSize);
			map.put("totalPages", totalPages);
			map.put("totalRecords", totalRecords);
			map.put("data", list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库链接
			cm.closeConnection();
		}

		return map;
	}

}
