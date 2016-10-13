package com.learn.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Comment {
	
	private Integer commentId;
	private String comment;
	
	private List<Link> links = new ArrayList<>();
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(Integer commentId, String comment) {
		super();
		this.commentId = commentId;
		this.comment = comment;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	//@XmlTransient : use to exclude in json or xml response.
	public List<Link> getLinks() {
		return links;
	}


	public void setLinks(List<Link> links) {
		this.links = links;
	}


	//@XmlTransient
	public void addLink(Link link){
		this.links.add(link);
	}
	

}
