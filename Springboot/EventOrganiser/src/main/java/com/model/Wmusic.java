package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Wmusic {
	
	@Id@GeneratedValue
	private int id;
private String name;
private String description;
private int price;
private byte[] imgsrc;
public Wmusic() {
	super();
	// TODO Auto-generated constructor stub
}
public Wmusic(String name, String description, int price, byte[] imgsrc) {
	super();
	this.name = name;
	this.description = description;
	this.price = price;
	this.imgsrc = imgsrc;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public byte[] getImgsrc() {
	return imgsrc;
}
public void setImgsrc(byte[] imgsrc) {
	this.imgsrc = imgsrc;
}

}