package com.netshop.dao;

import java.sql.SQLException;

import com.netshop.model.Items;
import com.netshop.pager.PageBean;

public interface ItemsDao {
	//����IDɾ����Ʒ
	public void delete(int itemid) throws SQLException;
	
	//����Ʒ��ģ����ѯ
	public PageBean<Items> findByItemname(String iname, int pc) throws SQLException;
    
	//�����Ʒ
	public void add(Items item) throws SQLException;
	
	//����Ʒ���ģ����ѯ
	public PageBean<Items> findByType(String itype, int pc) throws SQLException;

}
