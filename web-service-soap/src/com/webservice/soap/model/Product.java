package com.webservice.soap.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="product")
@XmlType(propOrder={"name","price"})
public class Product {
	
	private int price;
	private String name;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name,int price) {
		this.name = name;
		this.price = price;
	}
	@XmlElement(name="cost")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@XmlElement(name="productName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
