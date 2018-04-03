package com.oddjob.biz;

import java.util.List;
import java.util.Map;

import com.oddjob.dao.WorkDao;
import com.oddjob.entity.Work;
import com.oddjob.ibiz.IWorkBiz;
import com.oddjob.idao.IWorkDao;

public class WorkBiz implements IWorkBiz {

	//新建数据访问对象
	private IWorkDao iwdao = new WorkDao();
	@Override
	public List getWorkbyName(String name) {
		//返回
		return iwdao.getWorkbyName(name);
	}

	@Override
	public Work getWorkById(String id) {
		return iwdao.getWorkById(id);
	}

	@Override
	public int updateWork(Work work) {
		
		return iwdao.addWork(work);
	}

	@Override
	public int addWork(Work work) {
		
		return iwdao.addWork(work);
	}

	@Override
	public int delWork(int id) {
		 
		return iwdao.delWork(id);
	}

	@Override
	public Map getWorkTyesByPages(int pageNo, int pageSize, String keyword1,String keyword2) {
		 
		return iwdao.getWorkTyesByPages(pageNo, pageSize, keyword1, keyword2);
	}

	@Override
	public List getWorkByBid(String bossId) {
		 
		return iwdao.getWorkByBid(bossId);
	}

	
}
