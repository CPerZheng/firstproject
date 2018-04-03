package com.oddjob.ibiz;

import java.util.List;

import com.oddjob.entity.Admin;

/**
 * 业务逻辑层
 * @author Administrator
 *
 */
public interface IAdminBiz {

	/**
	 * 管理员登录方法
	 */
	public Admin login(String zh,String pwd);
	
	/**
	 * 增加管理员
	 */
	public int addAdmin(Admin admin);
	
	/**
	 * 修改管理员
	 */
	public int updateAdmin(Admin admin);
	
	/**
	 * 删除管理员
	 */
	public int delAdmin(int id);
	
	/**
	 * 根据管理员账号查询管理员
	 */
	public List getAdminItem(String zh);

	
}
