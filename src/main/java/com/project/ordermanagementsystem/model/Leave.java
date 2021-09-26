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

@Table(name = "leaves")
@Entity(name = "leaves")

public class Leave {

	private long leave_id;
	private String leave_product_id;
	private String leave_reason;
	private String leave_description;
	private String leave_from_date;
	private String leave_to_date;
	private String leave_status;
	
	public Leave(long leave_id, String leave_product_id, String leave_reason, String leave_description,
			String leave_from_date, String leave_to_date, String leave_status) {
		super();
		this.leave_id = leave_id;
		this.leave_product_id = leave_product_id;
		this.leave_reason = leave_reason;
		this.leave_description = leave_description;
		this.leave_from_date = leave_from_date;
		this.leave_to_date = leave_to_date;
		this.leave_status = leave_status;
	}

	@Override
	public String toString() {
		return "Leave [leave_id=" + leave_id + ", leave_product_id=" + leave_product_id + ", leave_reason="
				+ leave_reason + ", leave_description=" + leave_description + ", leave_from_date=" + leave_from_date
				+ ", leave_to_date=" + leave_to_date + ", leave_status=" + leave_status + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(long leave_id) {
		this.leave_id = leave_id;
	}

	public String getLeave_product_id() {
		return leave_product_id;
	}

	public void setLeave_product_id(String leave_product_id) {
		this.leave_product_id = leave_product_id;
	}

	public String getLeave_reason() {
		return leave_reason;
	}

	public void setLeave_reason(String leave_reason) {
		this.leave_reason = leave_reason;
	}

	public String getLeave_description() {
		return leave_description;
	}

	public void setLeave_description(String leave_description) {
		this.leave_description = leave_description;
	}

	public String getLeave_from_date() {
		return leave_from_date;
	}

	public void setLeave_from_date(String leave_from_date) {
		this.leave_from_date = leave_from_date;
	}

	public String getLeave_to_date() {
		return leave_to_date;
	}

	public void setLeave_to_date(String leave_to_date) {
		this.leave_to_date = leave_to_date;
	}

	public String getLeave_status() {
		return leave_status;
	}

	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}

	public Leave() {
	}
}
