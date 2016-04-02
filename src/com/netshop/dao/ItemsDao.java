package com.netshop.dao;

import java.sql.SQLException;

import com.netshop.model.Items;
import com.netshop.pager.PageBean;

public interface ItemsDao {
	//根据ID删除商品
	public void delete(int itemid) throws SQLException;
	
	//按商品名模糊查询
	public PageBean<Items> findByItemname(String iname, int pc) throws SQLException;
    
	//添加商品
	public void add(Items item) throws SQLException;
	
	//按商品类别模糊查询
	public PageBean<Items> findByType(String itype, int pc) throws SQLException;

}
