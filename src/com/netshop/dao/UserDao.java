package com.netshop.dao;

import java.sql.SQLException;

import com.netshop.model.User;

public interface UserDao {
	
	//添加客户信息
	public void add(User user) throws SQLException;
	
	//修改客户信息
	public  void update(User user)throws SQLException;
	
	//按用户名和密码查找用户
	public User findByLoginnameAndnpass(String uname,String upassword) throws SQLException ;
	
	//校验用户名是否注册
	public boolean ajaxValidateLoginname(String loginname) throws SQLException;
}
