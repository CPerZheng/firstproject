package com.oddjob.idao;

import java.util.List;
import java.util.Map;

import com.oddjob.entity.WorkType;

/**
 * 数据层接口
 * @author Administrator
 *
 */
public interface IWorkTypeDao {

	/**
	 * 根据零工类目名称查询零工类目
	 * 参数:零工类目名称
	 * 返回值:零工类目列表
	 */
	public List getWorkByName(String name);
	
	/**
	 * 根据编号查询类目
	 */
	public WorkType getWorkById(String id);
	
	/**
	 * 修改零工类目
	 */
	public int updateWork(WorkType wtype);
	
	/**
	 * 增加零工类目
	 */
	public int addWork(WorkType wtype);
	
	/**
	 * 删除零工类目
	 */
	public int delWork(int id);
	
	/*
	 * 获取商品类目列表，分页显示
	 * 参数：pageNo - 当前页，pageSize - 每页记录数，keyword - 查询字段
	 * 返回值：Map(pageNo-当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
	 */
	public Map getWorkTypePages(int pageNo,int pageSize,String keyword);
}
