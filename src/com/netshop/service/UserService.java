package com.netshop.service;

import com.netshop.model.User;

public interface UserService {
	//��¼
	public User login(User user);
	
	//ע��
	public void regist(User user);
	
	//�޸��û���Ϣ
	public void update(User user);
	
	//У���û����Ƿ�ע��
	public boolean ajaxValidateLoginname(String uname);
}
