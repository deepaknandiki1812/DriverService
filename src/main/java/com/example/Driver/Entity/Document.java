package com.example.Driver.Entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Document_Details")
public class Document {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Document_Id")
	private int id;
	
	@Column(name="File_Name")
	private String filename;
	
	@Column(name="File_Loc")
	private String fileloc;
	
	@Column(name="File_Size")
	private Long filesize;
	
	@Column(name="File_Ext")
	private String fileext;
	
	@Column(name="Uploaded_By")
	private String uploaded_by;
	
	@Column(name="Uploaded_Id")
	private int uploaded_id;
	
	@Column(name="Uploaded_Time")
	private Instant uploaded_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileloc() {
		return fileloc;
	}

	public void setFileloc(String fileloc) {
		this.fileloc = fileloc;
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public String getFileext() {
		return fileext;
	}

	public void setFileext(String fileext) {
		this.fileext = fileext;
	}

	public String getUploaded_by() {
		return uploaded_by;
	}

	public void setUploaded_by(String uploaded_by) {
		this.uploaded_by = uploaded_by;
	}

	public int getUploaded_id() {
		return uploaded_id;
	}

	public void setUploaded_id(int uploaded_id) {
		this.uploaded_id = uploaded_id;
	}

	public Instant getUploaded_time() {
		return uploaded_time;
	}

	public void setUploaded_time(Instant uploaded_time) {
		this.uploaded_time = uploaded_time;
	}

}
