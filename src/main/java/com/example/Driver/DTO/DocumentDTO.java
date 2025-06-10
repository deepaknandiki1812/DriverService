package com.example.Driver.DTO;

import java.time.Instant;

public class DocumentDTO {
	
	private int id;
	private String filename;
	private String fileloc;
	private Long filesize;
	private String fileext;
	private String uploaded_by;
	private int uploaded_id;
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
