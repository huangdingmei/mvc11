package com.netshop.service;

import com.netshop.model.User;

public interface UserService {
	//登录
	public User login(User user);
	
	//注册
	public void regist(User user);
	
	//修改用户信息
	public void update(User user);
	
	//校验用户名是否注册
	public boolean ajaxValidateLoginname(String uname);
}
