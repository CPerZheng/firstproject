package com.oddjob.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oddjob.entity.Work;
import com.oddjob.idao.IWorkDao;

public class WorkDao implements IWorkDao {

	// 建立数据库链接
	private ConnectManager cm = new ConnectManager();

	/**
	 * 根据零工名称查询零工
	 */
	@Override
	public List getWorkbyName(String name) {
		// 返回值
		List list = new ArrayList();

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from work where name like '%" + name + "%'";
			// 建立sql语句的执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);
			// 取出查询出来的类目列表
			while (rs.next()) {
				// 新建work对象
				Work w = new Work();

				w.setId(rs.getInt("id"));
				w.setBossId(rs.getInt("bossId"));
				w.setTy_id(rs.getInt("ty_id"));
				w.setName(rs.getString("name"));
				w.setType_name(rs.getString("type_name"));
				w.setImg(rs.getString("img"));
				w.setPrice(rs.getDouble("price"));
				w.setUser_name(rs.getString("user_name"));
				w.setPhone(rs.getString("phone"));
				w.setPe_num(rs.getInt("pe_num"));
				w.setAddress(rs.getString("address"));
				w.setsTime(rs.getString("sTime"));
				w.setdTime(rs.getString("dTime"));
				w.setContent(rs.getString("content"));

				// 存入list中
				list.add(w);
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
	 * 根据零工编号查询零工
	 */
	@Override
	public Work getWorkById(String id) {
		// 返回值
		Work work = null;

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from work where id=" + id;
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);
			// 取出查询出来的数据
			if (rs.next()) {
				// 获取数据
				int tid = rs.getInt("id");
				String tname = rs.getString("name");

				// 新建work对象
				work = new Work();

				work.setId(rs.getInt("id"));
				work.setBossId(rs.getInt("bossId"));
				work.setTy_id(rs.getInt("ty_id"));
				work.setName(rs.getString("name"));
				work.setType_name(rs.getString("type_name"));
				work.setImg(rs.getString("img"));
				work.setPrice(rs.getDouble("price"));
				work.setUser_name(rs.getString("user_name"));
				work.setPhone(rs.getString("phone"));
				work.setPe_num(rs.getInt("pe_num"));
				work.setAddress(rs.getString("address"));
				work.setsTime(rs.getString("sTime"));
				work.setdTime(rs.getString("dTime"));
				work.setContent(rs.getString("content"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭数据库链接
			cm.closeConnection();
		}
		// 返回值
		return work;
	}

	/**
	 * 修改零工
	 */
	@Override
	public int updateWork(Work work) {
		// 返回值
		int num = 0;
		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "update work set bossId='" + work.getBossId()
					+ "',ty_id='" + work.getTy_id() + "',name='"
					+ work.getName() + "',type_name='" + work.getType_name()
					+ "',img='" + work.getImg() + "',price=" + work.getPrice()
					+ ",user_name='" + work.getUser_name() + "',phone='"
					+ work.getPhone() + "',pe_num=" + work.getPe_num()
					+ ",address='" + work.getAddress() + "',sTime='"
					+ work.getsTime() + "',dTime='" + work.getdTime()
					+ "',content='" + work.getContent() + "' where id=" +work.getId();
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

		// 返回值
		return num;
	}

	/**
	 * 增加零工
	 */
	@Override
	public int addWork(Work work) {
		// 返回值
		int num = 0;
		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "insert into work(bossId,ty_id,name,type_name,img,price,user_name,phone,pe_num,address,sTime,dTime,content) values('"
					+ work.getBossId()
					+ "','"
					+ work.getTy_id()
					+ "','"
					+ work.getName()
					+ "','"
					+ work.getType_name()
					+ "','"
					+ work.getImg()
					+ "',"
					+ work.getPrice()
					+ ",'"
					+ work.getUser_name()
					+ "','"
					+ work.getPhone()
					+ "',"
					+ work.getPe_num()
					+ ",'"
					+ work.getAddress()
					+ "','"
					+ work.getsTime()
					+ "','"
					+ work.getdTime()
					+ "','"
					+ work.getContent() + "') ";
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
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
	 * 根据零工编号删除零工
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
			// 创建sql语句
			String sql = "delete from work where id=" + id;
			// 创建sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
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

	/*
	 * 获取商品列表，分页显示 参数：pageNo - 当前页，pageSize - 每页记录数，keyword - 查询字段
	 * 返回值：Map(pageNo
	 * -当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
	 */
	@Override
	public Map getWorkTyesByPages(int pageNo, int pageSize, String keyword1,
			String keyword2) {
		// 返回值
		Map map = new HashMap();
		// 分页数据
		List list = new ArrayList();
		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句,查询出总记录数并计算总页数
			String sql = "select count(*) as totalRecords from work where name like '%"
					+ keyword1 + "%'";

			if (keyword2 == null && !keyword2.equals("")) {
				sql += "and type_name=" + keyword2;
			}

			// 查询操作
			// 创建查询对象
			Statement stm = con.createStatement();
			// 执行查询操作
			ResultSet rs = stm.executeQuery(sql);

			// 获取总记录数据
			int totalRecords = 0;
			if (rs.next()) {
				totalRecords = rs.getInt("totalRecords");
			}

			// 获取总页数
			int totalPages = 0;
			if (totalRecords % pageSize == 0) {
				totalPages = totalRecords / pageSize;
			} else {
				totalPages = totalRecords / pageSize + 1;
			}

			// 查询出分页数据
			// 计算分页所以
			int index = (pageNo - 1) * pageSize;

			sql = "select w.*,t.name as type_name from work w,worktype t where w.ty_id = t.id and w.name like '%"+keyword1+"%' ";
			if(keyword2 != null && !keyword2.equals("")) {
				sql += "and w.ty_id = " + keyword2;
			}
			sql += " limit "+index+","+pageSize;
			
			
			//创建查询对象
			Statement stm_1 = con.createStatement();
			//执行查询操作
			ResultSet rs_1 = stm_1.executeQuery(sql);
			//获取分页数据(if:只取一条数据;while:可取多条数据;)
			while(rs_1.next()) {
				Work w = new Work();
				
				w.setId(rs_1.getInt("id"));
				w.setBossId(rs_1.getInt("bossId"));
				w.setTy_id(rs_1.getInt("ty_id"));
				w.setName(rs_1.getString("name"));
				w.setType_name(rs_1.getString("type_name"));
				w.setImg(rs_1.getString("img"));
				w.setPrice(rs_1.getDouble("price"));
				w.setUser_name(rs_1.getString("user_name"));
				w.setPhone(rs_1.getString("phone"));
				w.setPe_num(rs_1.getInt("pe_num"));
				w.setAddress(rs_1.getString("address"));
				w.setsTime(rs_1.getString("sTime"));
				w.setdTime(rs_1.getString("dTime"));
				w.setContent(rs_1.getString("content"));
				
				//存储到list中
				list.add(w);
			}
			
			//封装返回的Map对象
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
			//关闭数据库连接
			cm.closeConnection();
		}
		// 返回值
		return map;
	}

	@Override
	public List getWorkByBid(String bossId) {
		 //返回值
		List list = new ArrayList();
		
		//获取数据库链接
		Connection con = null;
		
		try {
			//获取数据库链接
			con = cm.getConnection_jdbc();
			//建立sql语句
			String sql = "select * from work where bossId=" + bossId;
			//建立sql语句执行对象
			Statement stm = con.createStatement();
			//执行sql语句
			ResultSet rs = stm.executeQuery(sql);
			
			//将查询结果取出来
			while(rs.next()) {
				//新建零工对象
				Work work = new Work();
				
				work.setId(rs.getInt("id"));
				work.setBossId(rs.getInt("bossId"));
				work.setTy_id(rs.getInt("ty_id"));
				work.setName(rs.getString("name"));
				work.setType_name(rs.getString("type_name"));
				work.setImg(rs.getString("img"));
				work.setPrice(rs.getDouble("price"));
				work.setUser_name(rs.getString("user_name"));
				work.setPhone(rs.getString("phone"));
				work.setPe_num(rs.getInt("pe_num"));
				work.setAddress(rs.getString("address"));
				work.setsTime(rs.getString("sTime"));
				work.setdTime(rs.getString("dTime"));
				work.setContent(rs.getString("content"));
				
				//存到list中
				list.add(work);
				
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
		
		//返回
		return list;
	}

}
