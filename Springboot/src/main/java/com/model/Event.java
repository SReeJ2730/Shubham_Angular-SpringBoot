package com.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class Event {

	@Id@GeneratedValue
	private int eventId;
	private String eventName;
	private String location;
	private int noMembers;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="id")
	Customer customer;
	
	public Event() {
		super();
	}

	public Event(int eventId, String eventName, String location, int noMembers, Date date,Customer customer) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.location = location;
		this.noMembers = noMembers;
		this.date = date;
		this.customer=customer;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
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

	public int getNoMembers() {
		return noMembers;
	}

	public void setNoMembers(int noMembers) {
		this.noMembers = noMembers;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	


}