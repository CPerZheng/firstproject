package com.oddjob.idao;

import java.util.List;
import java.util.Map;

import com.oddjob.entity.Work;

/**
 * 数据层接口
 * @author Administrator
 *
 */
public interface IWorkDao {

	/**
	 * 根据零工名称查询零工
	 */
	public List getWorkbyName(String name);
	
	/**
	 * 根据零工编号查询零工
	 */
	public Work getWorkById(String id);
	
	/**
	 * 修改零工
	 */
	public int updateWork(Work work);
	
	/**
	 * 增加零工
	 */
	public int addWork(Work work);
	
	/**
	 * 根据零工编号删除零工
	 */
	public int delWork(int id);
	
	/**
	 * 获取商品类目列表，分页显示
	 * 参数：pageNo - 当前页，pageSize - 每页记录数，keyword - 查询字段
	 * 返回值：Map(pageNo-当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
	 */
	public Map getWorkTyesByPages(int pageNo,int pageSize,String keyword1,String keyword2);
	
	/**
	 * 根据用户发单编号查询零工
	 */
	public List getWorkByBid(String bossId);

}
