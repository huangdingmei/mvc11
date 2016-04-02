package com.netshop.service.implement;

import java.sql.SQLException;

import com.netshop.dao.ItemsDao;
import com.netshop.dao.implement.ItemsDaoImpl;
import com.netshop.model.Items;
import com.netshop.pager.PageBean;
import com.netshop.service.ItemsService;

/** 
* @ClassName: ItemsServiceImpl
* @Description: ��Ʒģ��ҵ���
* @author  hdm
* @date ����ʱ�䣺2016��4��1�� ����10:05:06
* @version=1.0
*/
public class ItemsServiceImpl implements ItemsService {
	public ItemsDao itemsDao=new ItemsDaoImpl();
	
	/**
	 * ɾ����Ʒ
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
	 * ����Ʒ���飨ģ����ѯ��
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
	 * ������ģ����ѯ
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
	 * �����Ʒ
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
