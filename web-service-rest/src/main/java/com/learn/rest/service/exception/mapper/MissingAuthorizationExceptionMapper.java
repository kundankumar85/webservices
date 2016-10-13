package com.learn.rest.service.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.learn.rest.service.exception.ErrorDetails;
import com.learn.rest.service.exception.MissingAuthorizationException;

@Provider
public class MissingAuthorizationExceptionMapper implements ExceptionMapper<MissingAuthorizationException>{

	@Override
	public Response toResponse(MissingAuthorizationException exception) {
		ErrorDetails details = new ErrorDetails(404, "Authorization header is missing.");
		return Response.status(Status.NOT_FOUND).entity(details).build();
	}

}
