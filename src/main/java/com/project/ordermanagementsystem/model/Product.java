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

@Table
@Entity(name = "product")
public class Product {
	private long product_id;
	private String product_category_id;
	private String product_code;
	private String product_stock;
	private String product_title;
	private String product_price_per_item;
	private String product_description;
	private String product_mfd_date;
	private String product_exp_date;
	private String product_company;
	
	public Product() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_category_id() {
		return product_category_id;
	}

	public void setProduct_category_id(String product_category_id) {
		this.product_category_id = product_category_id;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(String product_stock) {
		this.product_stock = product_stock;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public String getProduct_price_per_item() {
		return product_price_per_item;
	}

	public void setProduct_price_per_item(String product_price_per_item) {
		this.product_price_per_item = product_price_per_item;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getProduct_mfd_date() {
		return product_mfd_date;
	}

	public void setProduct_mfd_date(String product_mfd_date) {
		this.product_mfd_date = product_mfd_date;
	}

	public String getProduct_exp_date() {
		return product_exp_date;
	}

	public void setProduct_exp_date(String product_exp_date) {
		this.product_exp_date = product_exp_date;
	}

	public String getProduct_company() {
		return product_company;
	}

	public void setProduct_company(String product_company) {
		this.product_company = product_company;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_category_id=" + product_category_id + ", product_code="
				+ product_code + ", product_stock=" + product_stock + ", product_title=" + product_title
				+ ", product_price_per_item=" + product_price_per_item + ", product_description=" + product_description
				+ ", product_mfd_date=" + product_mfd_date + ", product_exp_date=" + product_exp_date
				+ ", product_company=" + product_company + "]";
	}

	public Product(long product_id, String product_category_id, String product_code, String product_stock,
			String product_title, String product_price_per_item, String product_description, String product_mfd_date,
			String product_exp_date, String product_company) {
		super();
		this.product_id = product_id;
		this.product_category_id = product_category_id;
		this.product_code = product_code;
		this.product_stock = product_stock;
		this.product_title = product_title;
		this.product_price_per_item = product_price_per_item;
		this.product_description = product_description;
		this.product_mfd_date = product_mfd_date;
		this.product_exp_date = product_exp_date;
		this.product_company = product_company;
	}
	
	
}
