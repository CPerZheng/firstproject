package com.oddjob.biz;

import java.util.List;
import java.util.Map;

import com.oddjob.dao.UsersDao;
import com.oddjob.entity.Users;
import com.oddjob.ibiz.IUserBiz;
import com.oddjob.idao.IUsersDao;

public class UsersBiz implements IUserBiz {

	//新建数据访问层对象
	private IUsersDao iudao = new UsersDao();
	
	@Override
	public Users login(String zh, String pwd) {
		 
		return iudao.login(zh, pwd);
	}

	@Override
	public Users getUserById(String id) {
		 
		return iudao.getUserById(id);
	}

	@Override
	public List getUserByZh(String zh) {
		 
		return iudao.getUserByZh(zh);
	}

	@Override
	public int updateUser(Users user) {
		 
		return iudao.updateUser(user);
	}

	@Override
	public int addUser(Users user) {
		 
		return iudao.addUser(user);
	}

	@Override
	public Users getUserByOnlyZh(String zh) {
		 
		return iudao.getUserByOnlyZh(zh);
	}
	
	
	@Override
	public Users getUserByNameId(String name, String id) {
		 
		return iudao.getUserByNameId(name, id);
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
	
}
