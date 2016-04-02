package com.netshop.model;

import java.sql.Date;

public class Order {
	public int o_id;
	public int o_cid;
	public Date o_date;
	public String u_evaluation;

	public String getU_evaluation() {
		return u_evaluation;
	}

	public void setU_evaluation(String u_evaluation) {
		this.u_evaluation = u_evaluation;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getO_cid() {
		return o_cid;
	}

	public void setO_cid(int o_cid) {
		this.o_cid = o_cid;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public Order(int o_id, int o_cid, Date o_date, String u_evaluation) {
		super();
		this.o_id = o_id;
		this.o_cid = o_cid;
		this.o_date = o_date;
		this.u_evaluation = u_evaluation;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
