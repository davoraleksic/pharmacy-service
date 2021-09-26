package com.project.ordermanagementsystem.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "company")
@Entity(name = "company")

public class Company {

	private long company_id;
	private String company_name;
	private String company_description;
	
	public Company() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCompany_id() {
		return company_id;
	}

	public Company(long company_id, String company_name, String company_description) {
		super();
		this.company_id = company_id;
		this.company_name = company_name;
		this.company_description = company_description;
	}

	@Override
	public String toString() {
		return "Company [company_id=" + company_id + ", company_name=" + company_name + ", company_description="
				+ company_description + "]";
	}

	public void setCompany_id(long company_id) {
		this.company_id = company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_description() {
		return company_description;
	}

	public void setCompany_description(String company_description) {
		this.company_description = company_description;
	}
	
}
