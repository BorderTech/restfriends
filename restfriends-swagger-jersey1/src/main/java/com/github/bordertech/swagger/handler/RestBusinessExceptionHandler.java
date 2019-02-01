package com.github.bordertech.swagger.handler;

import com.github.bordertech.restfriends.envelope.ErrorDetail;
import com.github.bordertech.restfriends.envelope.ErrorResponse;
import com.github.bordertech.restfriends.exception.RestBusinessException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Handle business exceptions with a standard error response.
 */
@Provider
public class RestBusinessExceptionHandler implements ExceptionMapper<RestBusinessException> {

	@Override
	public Response toResponse(final RestBusinessException exception) {
		ErrorDetail errorDetail = new ErrorDetail(exception.getStatusCode(), exception.getMessage());
		ErrorResponse resp = new ErrorResponse(errorDetail);
		return Response.status(errorDetail.getStatus()).
				entity(resp).
				type("application/json").
				build();
	}
}
