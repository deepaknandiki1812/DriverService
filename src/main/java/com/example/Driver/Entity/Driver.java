package com.example.Driver.Entity;


import java.sql.Blob;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Driver_details")
public class Driver {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Driver_ID")
	private int id;
	
	@Column(name="Driver_Name")
	private String Name;
	
	@Column(name="Driver_email")
	private String email;
	
	@Column(name="Driver_Address")
	private String address;
	
	@Column(name="Driver_vehicleNumber")
	private String vehicleNumber;
	
	@Column(name="Driver_JoinDate")
	private Timestamp joindate;
	
	@Column(name="Driver_ImagePath")
	private String imagepath;
	
	@Column(name="Driver_Vehicletype")
	private String vehicletype;
	
	@Column(name="Driver_LicencePath")
	private String licencepath;
	
	
	@Column(name="Driver_Status")
	private Boolean status;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
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


	
	
}