package com.netshop.model;

import java.util.Date;

/** 
* @Description: 商品模块实体类
*/
public class Items {
	public int item_id;// 商品ID，主键
	public int item_mid;// 厂家ID
	public String item_name;// 商品名称
	public double item_price;// 商品单价
	public Date item_gdate;// 生产日期
	public int item_caid;// 商品类型id
	public String item_pic;//商品图片存储路径
    public String item_descn;//商品描述
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_mid() {
		return item_mid;
	}
	public void setItem_mid(int item_mid) {
		this.item_mid = item_mid;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getItem_price() {
		return item_price;
	}
	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}
	public Date getItem_gdate() {
		return item_gdate;
	}
	public void setItem_gdate(Date item_gdate) {
		this.item_gdate = item_gdate;
	}
	public int getItem_caid() {
		return item_caid;
	}
	public void setItem_caid(int item_caid) {
		this.item_caid = item_caid;
	}
	public String getItem_pic() {
		return item_pic;
	}
	public void setItem_pic(String item_pic) {
		this.item_pic = item_pic;
	}
	public String getItem_descn() {
		return item_descn;
	}
	public void setItem_descn(String item_descn) {
		this.item_descn = item_descn;
	}
	public Items(int item_id, int item_mid, String item_name, double item_price, Date item_gdate, int item_caid,
			String item_pic, String item_descn) {
		super();
		this.item_id = item_id;
		this.item_mid = item_mid;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_gdate = item_gdate;
		this.item_caid = item_caid;
		this.item_pic = item_pic;
		this.item_descn = item_descn;
	}
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
}
