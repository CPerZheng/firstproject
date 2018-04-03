package com.oddjob.entity;

/**
 * 用户列表实体类
 * @author Administrator
 *
 */
public class UsersItem {

	private int id;//用户列表编号
	private int u_id;//用户编号
	private String img;//用户图片
	private String u_name;//用户姓名
	private String u_phone;	//用户电话
	private String type_name;//零工类型
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	
}
