package com.netshop.dao;

import java.sql.SQLException;

import com.netshop.model.User;

public interface UserDao {
	
	//��ӿͻ���Ϣ
	public void add(User user) throws SQLException;
	
	//�޸Ŀͻ���Ϣ
	public  void update(User user)throws SQLException;
	
	//���û�������������û�
	public User findByLoginnameAndnpass(String uname,String upassword) throws SQLException ;
	
	//У���û����Ƿ�ע��
	public boolean ajaxValidateLoginname(String loginname) throws SQLException;
}
