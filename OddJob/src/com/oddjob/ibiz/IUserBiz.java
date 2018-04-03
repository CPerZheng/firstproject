package com.oddjob.ibiz;

import java.util.List;
import java.util.Map;

import com.oddjob.entity.Users;

/**
 * 业务逻辑层
 * @author Administrator
 *
 */
public interface IUserBiz {

	/**
	 * 用户登录
	 */
	public Users login(String zh,String pwd);
	/**
	 * 根据用户编号查询用户
	 */
	public Users getUserById(String id);
	
	/**
	 * 根据用户账号查找用户(列表)
	 */
	public List getUserByZh(String zh);
	
	/**
	 * 根据用户账号查询用户
	 */
	public Users getUserByOnlyZh(String zh);
	
	/**
	 * 修改用户
	 */
	public int updateUser(Users user);
	
	/**
	 * 增加用户
	 */
	public int addUser(Users user);
	
	/**
	 * 根据用户编号删除用户
	 */
	public int delUser(int id);
	
	/**
	 * 获取用户列表参数：pageNo - 当前页，pageSize - 每页记录数，keyword - 查询字段
	 * 返回值：Map(pageNo-当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
	 */
	public Map getUserPages(int pageNo,int pageSize,String keyword3);
	
	/**
	 * 获取用户列表，接单用户的
	 * 参数：users_id - 接单的用户编号
	 * 返回值：用户列表
	 */
	public List getUsersIdItem(String users_id);
	
	/**
	 * 根据用户名和用户编号
	 */
	public Users getUserByNameId(String name,String id);
}
