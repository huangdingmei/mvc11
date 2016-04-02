package com.netshop.text;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.netshop.dao.ItemsDao;
import com.netshop.dao.implement.ItemsDaoImpl;
import com.netshop.model.Items;

public class ItemsDaoImplText {
  private ItemsDao itemsDao=new ItemsDaoImpl();
	@Test
	public void testDelete() throws SQLException {
		itemsDao.delete(1);
	}

	@Test
	public void testFindByItemname() throws SQLException {
		
	}

	@Test
	public void testFindByType() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() throws SQLException {
		Items item=new Items();
		item.setItem_name("aa");
		item.setItem_caid(1);
		item.setItem_gdate(null);
		item.setItem_mid(1);
		item.setItem_price(99);
		item.setItem_pic(null);
		itemsDao.add(item);
	}

}
