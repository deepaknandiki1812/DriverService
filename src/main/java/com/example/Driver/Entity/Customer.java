package com.example.Driver.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_info")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Customer_Name")
	private String name;
	
	@Column(name="Customer_Age")
	private int age;
	
	@Column(name="Customer_Address")
	private String address;
	
	@Column(name="Customer_Area")
	private String area;
	
	@Column(name="Pension_id")
	private String Pension_id;
	
	@Column(name="Customer_Email")
	private String email;
	
	@Column(name="Customer_Contact")
	private String contact;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getarea() {
		return area;
	}
	public void setarea(String area) {
		this.area = area;
	}
	public String getPension_id() {
		return  Pension_id;
	}
	public void setPension_id(String  Pension_id) {
		this. Pension_id =  Pension_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
