package com.netshop.service;

import com.netshop.model.Items;
import com.netshop.pager.PageBean;

public interface ItemsService {
	//ɾ����Ʒ
	public void delete(int itemid);
	
	//����Ʒ��ģ����ѯ
	public PageBean<Items> findByItemname(String iname, int pc);
	
	//������ģ����ѯ
	public PageBean<Items> findByType(String iname, int pc);
	
	//�����Ʒ
	public void add(Items items);
		
}
