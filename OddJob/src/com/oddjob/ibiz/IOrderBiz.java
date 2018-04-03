package com.oddjob.ibiz;

import java.util.List;
import java.util.Map;

import com.oddjob.entity.Order;

/**
 * 业务管理层
 * @author Administrator
 *
 */
public interface IOrderBiz {

	/**
	 * 根据订单编号获取订单
	 */
	public Order getOrderById(int id);
	
	/**
	 * 根据订单名称获取订单
	 */
	public List getOrderByName(String name);
	
	/**
	 * 根据订单编号，查询订单详细信息
	 */
	public List getOrderItem(String id);
	
	/**
	 * 修改订单
	 */
	public int updateOrder(Order order,int op);
	
	/**
	 * 增加订单
	 */
	public int addOrder(Order order,List olist);
	
	/**
	 * 删除订单
	 */
	public int delOrder(int id);
	
	/**
	 * 获取订单列表，分页显示
	 * 参数：pageNo - 当前页，pageSize - 每页记录数，keyword - 查询字段
	 * 返回值：Map(pageNo-当前页，pageSize-每页记录数，totalPages-总页数，totalRecords-总记录数，data-分页数据)
	 */
	public Map getOrderPages(int pageNo,int pageSize,String keyword1,String keyword2);
	
	/**
	 * 根据用户编号查询订单
	 */
	public List getOrderByuId(String u_staffId);
}
