package com.netshop.service.implement;

import java.sql.SQLException;

import com.netshop.dao.ItemsDao;
import com.netshop.dao.implement.ItemsDaoImpl;
import com.netshop.model.Items;
import com.netshop.pager.PageBean;
import com.netshop.service.ItemsService;

/** 
* @ClassName: ItemsServiceImpl
* @Description: 商品模块业务层
* @author  hdm
* @date 创建时间：2016年4月1日 下午10:05:06
* @version=1.0
*/
public class ItemsServiceImpl implements ItemsService {
	public ItemsDao itemsDao=new ItemsDaoImpl();
	
	/**
	 * 删除商品
	 * @param itemid
	 */
	@Override
	public void delete(int itemid) {
		try {
			itemsDao.delete(itemid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按商品名查（模糊查询）
	 * @param iname
	 * @param pc
	 * @return
	 */
	public PageBean<Items> findByItemname(String iname, int pc) {
		try {
			return itemsDao.findByItemname(iname, pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 按分类模糊查询
	 * @param iname
	 * @param pc
	 * @return
	 */
	public PageBean<Items> findByType(String iname, int pc) {
		try {
			return itemsDao.findByType(iname, pc);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 添加商品
	 * @param items
	 */
	public void add(Items items) {
		try {
			itemsDao.add(items);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
