package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Customer {
	@Id@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private String country;
	private String address;
	private String emailId;
	private String password;
	private String PhoneNo;
    private Date dob;
    
    @JsonIgnore
 @OneToMany(mappedBy="customer")
List<Event> eventList = new ArrayList<Event>();

    
	public Customer() {
		super();
	}
	
	
	public Customer(String firstName,String lastName,String gender,  String country, String address, String emailId,
			String password, String PhoneNo, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.address = address;
		this.emailId = emailId;
		this.password = password;
		this.PhoneNo = PhoneNo;
		this.dob = dob;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String PhoneNo) {
		this.PhoneNo = PhoneNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Event> getEventList() {
		return eventList;
	}
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	
}


