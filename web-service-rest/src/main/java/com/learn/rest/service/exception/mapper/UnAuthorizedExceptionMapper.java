package com.learn.rest.service.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.learn.rest.service.exception.ErrorDetails;
import com.learn.rest.service.exception.UnAuthorizedException;

@Provider
public class UnAuthorizedExceptionMapper implements ExceptionMapper<UnAuthorizedException> {

	@Override
	public Response toResponse(UnAuthorizedException exception) {
		ErrorDetails details = new ErrorDetails(401, "You are not allowd to access this resource.");
		return Response.status(Status.UNAUTHORIZED).entity(details).build();
	}

}
