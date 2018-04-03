package com.oddjob.entity;

/**
 * 零工信息实体类填写(用户填写)
 * @author Administrator
 *
 */
public class Work {

	private int id;//零工编号
	private int bossId;//发单用户编号
	private int ty_id;//零工类目编号
	private String name;//零工标题
	private String type_name;//零工类型
	private String img;//图片
	private double price;//佣金
	private String user_name;//用户名
	private String phone;//发布者电话
	private int pe_num;//招募人数
	private String address;//地址
	private String sTime;//发布时间
	private String dTime;//结束时间
	private String content;//内容
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBossId() {
		return bossId;
	}
	public void setBossId(int bossId) {
		this.bossId = bossId;
	}
	public int getTy_id() {
		return ty_id;
	}
	public void setTy_id(int ty_id) {
		this.ty_id = ty_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPe_num() {
		return pe_num;
	}
	public void setPe_num(int pe_num) {
		this.pe_num = pe_num;
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
	public String getdTime() {
		return dTime;
	}
	public void setdTime(String dTime) {
		this.dTime = dTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
