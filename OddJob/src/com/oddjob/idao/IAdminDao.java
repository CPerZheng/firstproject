package com.oddjob.idao;

import java.util.List;
import java.util.Map;

import com.oddjob.entity.Admin;

/**
 * 数据层接口
 * @author Administrator
 *
 */
public interface IAdminDao {

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
	
	/**
	 * 根据管理员编号查询管理员
	 */
	public Admin getAdminById(String id);
	
	/**
	 * 获取用户列表参数：pageNo - 当前页，pageSize - 每页记录数，keyword - 查询字段
	 * 返回值：Map(pageNo-当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
	 */
	public Map getAdminByPages(int pageNo,int pageSize,String keywords3);

	
}
