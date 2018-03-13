package com.cap.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties
public class Courses implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String code;
	private String description;
	private String duration;

	public Courses(String id, String code, String description, String duration) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.duration = duration;
	}

	public Courses() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}


}
