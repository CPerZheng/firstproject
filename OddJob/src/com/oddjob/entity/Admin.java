package com.oddjob.entity;
/**
 * 管理员实体类
 * @author Administrator
 *
 */
public class Admin {

	private int id;//管理员编号
	private String zh;//管理员账号
	private String pwd;//管理员密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}
