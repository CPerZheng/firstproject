package com.oddjob.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oddjob.entity.Users;
import com.oddjob.idao.IUsersDao;

public class UsersDao implements IUsersDao {

	// 建立数据库链接
	private ConnectManager cm = new ConnectManager();

	/**
	 * 用户登录
	 */
	@Override
	public Users login(String zh, String pwd) {

		// 返回值
		Users users = null;

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from users where zh='" + zh + "' and pwd='"
					+ pwd + "'";
			// 建立sql语句查询对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);

			// 判断是否存在此用户
			if (rs.next()) {
				// 新建用户对象
				users = new Users();

				users.setId(rs.getInt("id"));
				users.setBossId(rs.getInt("bossId"));
				users.setName(rs.getString("name"));
				users.setZh(rs.getString("zh"));
				users.setPwd(rs.getString("pwd"));
				users.setImg(rs.getString("img"));
				users.setSex(rs.getString("sex"));
				users.setPhone(rs.getString("phone"));
				users.setSpecialty(rs.getString("specialty"));
				users.setProfile(rs.getString("profile"));

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

		return users;
	}

	/**
	 * 根据用户编号获取用户
	 */
	@Override
	public Users getUserById(String id) {

		// 返回值
		Users users = null;
		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from users where id=" + id;
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);

			// 将查询结果取出来
			if (rs.next()) {
				users = new Users();

				users.setId(rs.getInt("id"));
				users.setBossId(rs.getInt("bossId"));
				users.setName(rs.getString("name"));
				users.setZh(rs.getString("zh"));
				users.setPwd(rs.getString("pwd"));
				users.setImg(rs.getString("img"));
				users.setSex(rs.getString("sex"));
				users.setPhone(rs.getString("phone"));
				users.setSpecialty(rs.getString("specialty"));
				users.setProfile(rs.getString("profile"));

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
		return users;
	}

	/**
	 * 根据用户名称查询账号
	 */
	@Override
	public List getUserByZh(String zh) {

		// 返回值
		List list = new ArrayList();
		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from users where zh like '%" + zh + "%'";
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 执行sql语句
			ResultSet rs = stm.executeQuery(sql);

			// 将结果取出来
			while (rs.next()) {
				// 新建用户对象
				Users u = new Users();

				u.setId(rs.getInt("id"));
				u.setBossId(rs.getInt("bossId"));
				u.setName(rs.getString("name"));
				u.setZh(rs.getString("zh"));
				u.setPwd(rs.getString("pwd"));
				u.setImg(rs.getString("img"));
				u.setSex(rs.getString("sex"));
				u.setPhone(rs.getString("phone"));
				u.setSpecialty(rs.getString("specialty"));
				u.setProfile(rs.getString("profile"));

				// 将结果存入List中
				list.add(u);

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
	 * 修改用户
	 */
	@Override
	public int updateUser(Users user) {

		// 返回值
		int num = 0;

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql数据库
			String sql = "update users set name='" + user.getName() + "',zh='"
					+ user.getZh() + "',img='" + user.getImg() + "',sex='"
					+ user.getSex() + "',phone='" + user.getPhone()
					+ "',specialty='" + user.getSpecialty() + "',profile='"
					+ user.getProfile() + "' where id=" + user.getId();
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
	 * 增加用户
	 */
	@Override
	public int addUser(Users user) {
		// 返回值
		int num = 0;

		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "insert into users(bossId,name,zh,pwd,img,sex,phone,specialty,profile) values("
					+ user.getBossId()
					+ ",'"
					+ user.getName()
					+ "','"
					+ user.getZh()
					+ "','"
					+ user.getPwd()
					+ "','"
					+ user.getImg()
					+ "','"
					+ user.getSex()
					+ "','"
					+ user.getPhone()
					+ "','"
					+ user.getSpecialty()
					+ "','"
					+ user.getProfile() + "')";
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

	@Override
	public int delUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map getUserPages(int pageNo, int pageSize, String keyword3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getUsersIdItem(String users_id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据用户账号查询
	 */
	@Override
	public Users getUserByOnlyZh(String zh) {
		// 返回值
		Users user = null;
		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from users where zh='" + zh + "'";
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			// 将查询结果取出来
			if (rs.next()) {
				user = new Users();

				user.setId(rs.getInt("id"));
				user.setBossId(rs.getInt("bossId"));
				user.setName(rs.getString("name"));
				user.setZh(rs.getString("zh"));
				user.setPwd(rs.getString("pwd"));
				user.setImg(rs.getString("img"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				user.setSpecialty(rs.getString("specialty"));
				user.setProfile(rs.getString("profile"));
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

		return user;
	}

	/**
	 * 根据用户名及用户编号查询用户
	 */

	@Override
	public Users getUserByNameId(String name, String id) {
		// 返回值
		Users user = null;
		// 获取数据库链接
		Connection con = null;

		try {
			// 获取数据库链接
			con = cm.getConnection_jdbc();
			// 建立sql语句
			String sql = "select * from users where name='" + name
					+ "' and id='" + id + "'";
			// 建立sql语句执行对象
			Statement stm = con.createStatement();
			// 将查询结果取出
			ResultSet rs = stm.executeQuery(sql);

			// 将查询结果取出来
			if (rs.next()) {
				user = new Users();

				user.setId(rs.getInt("id"));
				user.setBossId(rs.getInt("bossId"));
				user.setName(rs.getString("name"));
				user.setZh(rs.getString("zh"));
				user.setPwd(rs.getString("pwd"));
				user.setImg(rs.getString("img"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				user.setSpecialty(rs.getString("specialty"));
				user.setProfile(rs.getString("profile"));
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
		return user;
	}

}
