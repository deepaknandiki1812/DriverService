package com.example.Driver.DTO;


import java.sql.Timestamp;




public class DriverDTO {
	
	private int id;
	private String name;
	private String email;
	private String address;
	private String vehicleNumber;
	private Timestamp joindate;
	private String imagepath;
	private String vehicletype;
	private String licencepath;
	private Boolean status;
	private String imagename;
	private String licencename;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Timestamp getJoindate() {
		return joindate;
	}
	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	public String getLicencepath() {
		return licencepath;
	}
	public void setLicencepath(String licencepath) {
		this.licencepath = licencepath;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getLicencename() {
		return licencename;
	}
	public void setLicencename(String licencename) {
		this.licencename = licencename;
	}
	
	
	}