package com.project.ordermanagementsystem.model;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "orders")
@Entity(name = "orders")

public class Order {

	private long order_id;
	private String order_customer_name;
	private String order_customer_mobile;
	private String order_total;
	private String order_status;
	private String order_date;
	
	public Order() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getOrder_id() {
		return order_id;
	}

	public Order(long order_id, String order_customer_name, String order_customer_mobile, String order_total,
			String order_status, String order_date) {
		super();
		this.order_id = order_id;
		this.order_customer_name = order_customer_name;
		this.order_customer_mobile = order_customer_mobile;
		this.order_total = order_total;
		this.order_status = order_status;
		this.order_date = order_date;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public String getOrder_customer_name() {
		return order_customer_name;
	}

	public void setOrder_customer_name(String order_customer_name) {
		this.order_customer_name = order_customer_name;
	}

	public String getOrder_customer_mobile() {
		return order_customer_mobile;
	}

	public void setOrder_customer_mobile(String order_customer_mobile) {
		this.order_customer_mobile = order_customer_mobile;
	}

	public String getOrder_total() {
		return order_total;
	}

	public void setOrder_total(String order_total) {
		this.order_total = order_total;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_customer_name=" + order_customer_name
				+ ", order_customer_mobile=" + order_customer_mobile + ", order_total=" + order_total
				+ ", order_status=" + order_status + ", order_date=" + order_date + "]";
	}
}
