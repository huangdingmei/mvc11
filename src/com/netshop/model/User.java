package com.netshop.model;

/** 
* @Description: �û�ģ��ʵ����
*/
public class User {
	
	public User(){}
	public Integer  uid;//�û�ID
	public String uname;//�û���¼��
	public String upassword;//�û���¼����
	public String unickname;//�û��ǳ�
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
