package com.oddjob.entity;

/**
 * 订单详细实体类
 * @author Administrator
 *
 */
public class Order {

	private int id;//订单编号
	private int u_bossId;//发任务id
	private int u_staffId;//接任务id
	private String name;//订单名称
	private String img;//图片
	private String sTime;//发布时间
	private String dTime;//结束时间
	private String phone;//发布者的电话
	private String p_name;//发布者姓名
	private int pe_num;//招募人数
	private double price;//佣金
	private String type_name;//零工类目
	private String adress;//地址
	private String content;//内容
	private int state;//状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getU_bossId() {
		return u_bossId;
	}
	public void setU_bossId(int u_bossId) {
		this.u_bossId = u_bossId;
	}
	public int getU_staffId() {
		return u_staffId;
	}
	public void setU_staffId(int u_staffId) {
		this.u_staffId = u_staffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getPe_num() {
		return pe_num;
	}
	public void setPe_num(int pe_num) {
		this.pe_num = pe_num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
		
}
