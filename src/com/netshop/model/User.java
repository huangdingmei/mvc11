package com.netshop.model;

/** 
* @Description: 用户模块实体类
*/
public class User {
	
	public User(){}
	public Integer  uid;//用户ID
	public String uname;//用户登录名
	public String upassword;//用户登录密码
	public String unickname;//用户昵称
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUnickname() {
		return unickname;
	}
	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}
	public User(Integer uid, String uname, String upassword, String unickname) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.unickname = unickname;
	}
	
}
