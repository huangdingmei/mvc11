package com.netshop.service;

import com.netshop.model.Items;
import com.netshop.pager.PageBean;

public interface ItemsService {
	//删除商品
	public void delete(int itemid);
	
	//按商品名模糊查询
	public PageBean<Items> findByItemname(String iname, int pc);
	
	//按分类模糊查询
	public PageBean<Items> findByType(String iname, int pc);
	
	//添加商品
	public void add(Items items);
		
}
