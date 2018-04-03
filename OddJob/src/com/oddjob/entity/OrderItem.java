package com.oddjob.entity;

/**
 * 订单小列表
 * @author Administrator
 *
 */
public class OrderItem {

	private int id;//任务编号
	private int u_id;//用户编号
	private int o_id;//订单编号
	private String img;//图片
	private String lName;//订单名称
	private double price;//佣金
	private String address;//地址
	private String sTime;//开始时间
	private int state;//状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
