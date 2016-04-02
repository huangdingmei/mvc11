package com.netshop.model;

import java.math.BigDecimal;

/**
 * @ClassName: CartItem
 * @Description: ���ﳵ��չ����
 * @author hdm
 * @date ����ʱ�䣺2016��4��1�� ����10:26:57 @version=1.0
 */
public class CartItem {
	private String cartItemId;// ����
	private int quantity;// ��������
	private Items item;// ��Ŀ��Ӧ����Ʒ
	private User user;// �����û�
	private boolean inStock;// ��Ʒ������

	public boolean isinStock() {// �����Ƿ��п��
		return inStock;
	}

//	// ��ù�����Ʒ���ܼ�
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
