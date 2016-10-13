package com.learn.rest.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.learn.rest.dao.MessageDao;
import com.learn.rest.model.Link;
import com.learn.rest.model.Message;
import com.learn.rest.service.exception.NoDataFoundException;

//We can use @HeaderParam got get header value and @CookieParam to get cookie value.
@Path("/messages")
public class MessageResource {
	MessageDao dao = new MessageDao();
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Message> getAllMessage(){
		List<Message> messages = MessageDao.getAllMessages();
		return messages;
		
	}
	
	@RolesAllowed("ADMIN")
	@POST
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response addMessage(Message message){
		Message newMessage = MessageDao.addMessage(message);
		return Response.status(Status.CREATED).entity(newMessage).build();
		
	}
	
	
	@Path("/{messageid}")
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	public Message getMessage(@PathParam("messageid") Integer messageId,@Context UriInfo uriInfo){
		Message messages = MessageDao.getMessageById(messageId);
		if(null == messages){
			throw new NoDataFoundException();
		}
		Link link = getselfUri(messages, uriInfo);	
		Link commentlink = getCommentUri(messages, uriInfo);	
		messages.addLink(link);
		messages.addLink(commentlink);
		return messages;
		
	}
	
	private Link getselfUri(Message message, UriInfo uriInfo) {
		String url = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Integer.toString(message.getMessageId())).build().toString();
		Link link = new Link(url, "self");
		return link;
	}
	
	private Link getCommentUri(Message message, UriInfo uriInfo) {
		String url = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class).build(message.getMessageId()).toString();
				
		Link link = new Link(url, "comments");
		return link;
	}
	
	@RolesAllowed("ADMIN")
	//Sub resource demo
	@Path("/{messageid}/comments")
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public CommentResource getCommentResource(){
		return new CommentResource();
		
		
	}

}
