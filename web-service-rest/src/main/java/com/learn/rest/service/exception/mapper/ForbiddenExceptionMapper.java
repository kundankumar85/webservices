package com.learn.rest.service.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.learn.rest.service.exception.ErrorDetails;
import com.learn.rest.service.exception.ForbiddenException;
@Provider
public class ForbiddenExceptionMapper implements ExceptionMapper<ForbiddenException> {

	@Override
	public Response toResponse(ForbiddenException exception) {
		ErrorDetails details = new ErrorDetails(403, "No one can access this resource.");
		return Response.status(Status.FORBIDDEN).entity(details).build();
	}

}
