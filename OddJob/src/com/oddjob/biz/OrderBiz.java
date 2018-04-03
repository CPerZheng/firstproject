package com.oddjob.biz;

import java.util.List;
import java.util.Map;

import com.oddjob.dao.OrderDao;
import com.oddjob.entity.Order;
import com.oddjob.ibiz.IOrderBiz;

public class OrderBiz implements IOrderBiz {

	//新建数据访问层接口
	private OrderDao iodao = new OrderDao();
	
	@Override
	public Order getOrderById(int id) {
		 
		return iodao.getOrderById(id);
	}

	@Override
	public List getOrderByName(String name) {
		 
		return iodao.getOrderByName(name);
	}

	@Override
	public List getOrderItem(String id) {
		 
		return iodao.getOrderItem(id);
	}

	@Override
	public int updateOrder(Order order,int op) {
		 
		return iodao.updateOrder(order, op);
	}

	@Override
	public int addOrder(Order order, List olist) {
		 
		return iodao.addOrder(order, olist);
	}

	@Override
	public int delOrder(int id) {
		 
		return iodao.delOrder(id);
	}

	@Override
	public Map getOrderPages(int pageNo, int pageSize, String keyword1,
			String keyword2) {
		 
		return iodao.getOrderPages(pageNo, pageSize, keyword1, keyword2);
	}

	//根据用户编号查询订单
	@Override
	public List getOrderByuId(String u_staffId) {
		
		return iodao.getOrderByUid(u_staffId);
	}

}
