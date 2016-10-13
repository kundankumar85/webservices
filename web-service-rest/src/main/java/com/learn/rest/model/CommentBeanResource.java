package com.learn.rest.model;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

public class CommentBeanResource {
	
	private @PathParam("messageid") Integer messageId;
	private @PathParam("commentid") Integer commentid;
	private @Context UriInfo uriInfo;
	private @Context HttpHeaders headers;
	private @Context Cookie cookie;
	
	
	
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getCommentid() {
		return commentid;
	}
	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}
	public UriInfo getUriInfo() {
		return uriInfo;
	}
	public void setUriInfo(UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
	public HttpHeaders getHeaders() {
		return headers;
	}
	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
	public Cookie getCookie() {
		return cookie;
	}
	public void setCookie(Cookie cookie) {
		this.cookie = cookie;
	}

}
