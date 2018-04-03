package com.oddjob.entity;

/**
 * 用户实体类
 * @author Administrator
 *
 */
public class Users {

	private int id;//用户编号
	private int bossId;//用户发布编号
	private String name;//用户姓名
	private String zh;//用户账号
	private String pwd;//用户密码
	private String img;//图片
	private String sex;//性别
	private String phone;//电话
	private String specialty;//特长
	private String profile;//简介
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
