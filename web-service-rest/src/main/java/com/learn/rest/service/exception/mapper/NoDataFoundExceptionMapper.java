package com.learn.rest.service.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.learn.rest.service.exception.ErrorDetails;
import com.learn.rest.service.exception.NoDataFoundException;

@Provider
public class NoDataFoundExceptionMapper implements ExceptionMapper<NoDataFoundException>{

	@Override
	public Response toResponse(NoDataFoundException exception) {
		ErrorDetails details = new ErrorDetails(404, "Data not available");
		return Response.status(Status.NOT_FOUND).entity(details).build();
	}


}
