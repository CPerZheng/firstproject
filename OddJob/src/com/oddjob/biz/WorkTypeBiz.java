package com.oddjob.biz;

import java.util.List;
import java.util.Map;

import com.oddjob.dao.WorkTypeDao;
import com.oddjob.entity.WorkType;
import com.oddjob.ibiz.IWorkTypeBiz;

public class WorkTypeBiz implements IWorkTypeBiz {

	// 新建零工类目数据访问层对象
	private WorkTypeDao wtypedao = new WorkTypeDao();

	/**
	 * 根据零工类目查询零工类目
	 */
	@Override
	public List getWorkByName(String name) {

		return wtypedao.getWorkByName(name);
	}

	/**
	 * 根据零工类目编号查询零工类目
	 */
	@Override
	public WorkType getWorkById(String id) {

		return wtypedao.getWorkById(id);
	}

	/**
	 * 修改零工类目
	 */
	@Override
	public int updateWork(WorkType wtype) {

		return wtypedao.updateWork(wtype);
	}

	/**
	 * 增加零工类目
	 */
	@Override
	public int addWork(WorkType wtype) {

		return wtypedao.addWork(wtype);
	}

	/**
	 * 删除零工类目
	 */
	@Override
	public int delWork(int id) {

		return wtypedao.delWork(id);
	}

	/*
	 * 获取商品类目列表，分页显示
	 * 参数：pageNo - 当前页，pageSize - 每页记录数，keyword - 查询字段
	 * 返回值：Map(pageNo-当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
	 */
	@Override
	public Map getWorkTypePages(int pageNo, int pageSize, String keyword) {
		 
		return wtypedao.getWorkTypePages(pageNo, pageSize, keyword);
	}

}
