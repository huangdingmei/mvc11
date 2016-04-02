package com.netshop.model;

import java.math.BigDecimal;

/**
 * @ClassName: CartItem
 * @Description: 购物车扩展对象
 * @author hdm
 * @date 创建时间：2016年4月1日 下午10:26:57 @version=1.0
 */
public class CartItem {
	private String cartItemId;// 主键
	private int quantity;// 购买数量
	private Items item;// 条目对应的商品
	private User user;// 所属用户
	private boolean inStock;// 商品库存情况

	public boolean isinStock() {// 检验是否有库存
		return inStock;
	}

//	// 获得购物商品的总价
//	public double getTotalPrice() {
//		BigDecimal price1 = new BigDecimal(item.getItem_money() + "");
//		BigDecimal price2 = new BigDecimal(quantity + "");
//		BigDecimal price3 = price1.multiply(price2);
//		return price3.doubleValue();
//	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
}
