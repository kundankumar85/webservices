package com.learn.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private Integer messageId;
	private String message;
	
	private List<Link> links = new ArrayList<>();
	

	public Message(Integer messageId, String message) {
		super();
		this.messageId = messageId;
		this.message = message;
	}


	public Message() {
		
	}


	public Integer getMessageId() {
		return messageId;
	}


	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	
	
	public List<Link> getLinks() {
		return links;
	}


	public void setLinks(List<Link> links) {
		this.links = links;
	}


	public void addLink(Link link){
		this.links.add(link);
	}
	

}
