package com.learn.rest.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.learn.rest.dao.MessageDao;
import com.learn.rest.model.Comment;
import com.learn.rest.model.CommentBeanResource;
import com.learn.rest.model.Link;

@Path("/")
public class CommentResource {
	
	@RolesAllowed("ADMIN")
	@GET
	@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Comment> getComments(@PathParam("messageid") Integer messageId){
		return MessageDao.getMessageComments(messageId);
	}
	
	@RolesAllowed("ADMIN")
	@POST
	public Response addCommentsToMessage(@PathParam("messageid") Integer messageId,Comment comment){
		Comment comment2 =  MessageDao.addMessageComments(messageId, comment);
		return Response.status(Status.CREATED).entity(comment2).build();
	}
	@RolesAllowed("ADMIN")
	//Demo of @BeanParam
	@GET
	@Path("/{commentid}")
	public Comment getCommentsById(@BeanParam CommentBeanResource beanResource){
		Comment comment = MessageDao.getMessageCommentById(beanResource.getMessageId(),beanResource.getCommentid());
		comment.addLink(getselfUri(beanResource, beanResource.getUriInfo()));
		return comment;
	}
	
	private Link getselfUri(CommentBeanResource beanResource , UriInfo uriInfo) {
		String url = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class).path(this.getClass(),"getCommentsById").build(beanResource.getMessageId(),beanResource.getCommentid()).toString();
		Link link = new Link(url, "self");
		return link;
	}
	

}
