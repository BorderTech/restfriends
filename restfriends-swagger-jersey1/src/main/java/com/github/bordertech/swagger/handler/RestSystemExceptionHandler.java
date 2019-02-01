package com.github.bordertech.swagger.handler;

import com.github.bordertech.restfriends.envelope.ErrorDetail;
import com.github.bordertech.restfriends.envelope.ErrorResponse;
import com.github.bordertech.restfriends.exception.RestSystemException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Return system exceptions with a standard error response.
 */
@Provider
public class RestSystemExceptionHandler implements ExceptionMapper<RestSystemException> {

	@Override
	public Response toResponse(final RestSystemException exception) {
		ErrorDetail errorDetail = new ErrorDetail(exception.getStatusCode(), exception.getMessage());
		ErrorResponse resp = new ErrorResponse(errorDetail);
		return Response.status(errorDetail.getStatus()).
				entity(resp).
				type("application/json").
				build();
	}
}
