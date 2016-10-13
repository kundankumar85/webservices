package com.learn.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Link {
	
	private String resource;
	private String rel;
	
	public Link() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Link(String resource, String rel) {
		super();
		this.resource = resource;
		this.rel = rel;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	

}
