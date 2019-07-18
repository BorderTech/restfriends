package com.github.bordertech.swagger.handler;

import com.github.bordertech.restfriends.envelope.ErrorDetail;
import com.github.bordertech.restfriends.envelope.ErrorEnvelope;
import com.github.bordertech.restfriends.envelope.impl.ErrorResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Handle exceptions with a standard error response.
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(final Throwable exception) {
		ErrorDetail detail = createErrorDetail(exception);
		ErrorEnvelope resp = new ErrorResponse(detail);
		return Response.status(detail.getStatus()).
				entity(resp).
				type("application/json").
				build();
	}

	/**
	 * @param excp the original exception
	 * @return the error details
	 */
	protected ErrorDetail createErrorDetail(final Throwable excp) {
		// Default to Internal Error
		int status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
		String msg;
		if (excp == null) {
			msg = "Error has occurred but no exception provided.";
		} else {
			msg = excp.getMessage();
			if (excp.getCause() != null) {
				msg += " Cause: " + excp.getMessage();
			}
		}
		return new ErrorDetail(status, msg);
	}

}
