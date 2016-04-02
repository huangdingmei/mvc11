package com.netshop.dao.implement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.netshop.commons.CommonUtils;
import com.netshop.jdbc.DAO;
import com.netshop.model.CartItem;
import com.netshop.model.Items;
import com.netshop.model.User;


/** 
* @ClassName: CartItemDao
* @Description: 购物车持久层
* @author  hdm
* @date 创建时间：2016年4月2日 上午9:13:20
* @version=1.0
*/
public class CartItemDao {
	private QueryRunner qr = new DAO();

	// 用来生成where子句
	private String toWhereSql(int len) {
		StringBuilder sb = new StringBuilder("cartItemId in(");
		for (int i = 0; i < len; i++) {
			sb.append("?");
			if (i < len - 1) {
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	/**
	 * 加载多个CartItem
	 * 
	 * @param cartItemIds
	 * @return
	 * @throws SQLException
	 */
	public List<CartItem> loadCartItems(String cartItemIds) throws SQLException {

		// 把cartItemIds转换成数组
		Object[] cartItemIdArray = cartItemIds.split(",");

		// 生成wehre子句
		String whereSql = toWhereSql(cartItemIdArray.length);

		// 生成sql语句
		String sql = "select * from cartitem c, items i where c.cid=i.item_id and " + whereSql;

		// 执行sql，返回List<CartItem>
		return toCartItemList(qr.query(sql, new MapListHandler(), cartItemIdArray));
	}

	// 把多个Map(List<Map>)映射成多个CartItem(List<CartItem>)
	private List<CartItem> toCartItemList(List<Map<String, Object>> mapList) {
		List<CartItem> cartItemList = new ArrayList<CartItem>();
		for (Map<String, Object> map : mapList) {
			CartItem cartItem = toCartItem(map);
			cartItemList.add(cartItem);
		}
		return cartItemList;
	}

	// 把一个Map映射成一个Cartitem
	private CartItem toCartItem(Map<String, Object> map) {
		if (map == null || map.size() == 0)
			return null;
		CartItem cartItem = CommonUtils.toBean(map, CartItem.class);
		Items item = CommonUtils.toBean(map, Items.class);
		User user = CommonUtils.toBean(map, User.class);
		cartItem.setItem(item);
		cartItem.setUser(user);
		return cartItem;
	}
}
