package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Showbooked {
	
	@Id@GeneratedValue
    private int id;
	private String name;
	private String emailId;
	private String eventName;
	private String location;
	private String date;
	
	public Showbooked() {
		super();
		
	}
	public Showbooked(String name, String emailId, String eventName, String location, String date) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.eventName = eventName;
		this.location = location;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
