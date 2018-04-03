package com.oddjob.biz;

import java.util.List;

import com.oddjob.dao.AdminDao;
import com.oddjob.entity.Admin;
import com.oddjob.ibiz.IAdminBiz;
/**
 * 管理员的业务逻辑层,用于处理业务,主要是调用管理员的数据层
 * @author Administrator
 *
 */
public class AdminBiz implements IAdminBiz {

	//新建管理员数据访问层对象
	private AdminDao admindao = new AdminDao();
	@Override
	public Admin login(String zh, String pwd) {
		// TODO Auto-generated method stub
		return admindao.login(zh, pwd);
	}

	@Override
	public int addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.addAdmin(admin);
	}

	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.updateAdmin(admin);
	}

	@Override
	public int delAdmin(int id) {
		// TODO Auto-generated method stub
		return admindao.delAdmin(id);
	}

	@Override
	public List getAdminItem(String zh) {
		// TODO Auto-generated method stub
		return admindao.getAdminItem(zh);
	}

}
