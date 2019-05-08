package com.github.bordertech.restfriends.envelope.impl;

import com.github.bordertech.restfriends.envelope.ErrorDetail;
import com.github.bordertech.restfriends.envelope.ErrorEnvelope;

/**
 * Service error response with error details. `
 */
public class ErrorResponse implements ErrorEnvelope {

	private ErrorDetail error;

	/**
	 * Protected default constructor (used by libraries like jaxb).
	 */
	protected ErrorResponse() {
		this(null);
	}

	/**
	 * @param error the error detail
	 */
	public ErrorResponse(final ErrorDetail error) {
		this.error = error;
	}

	@Override
	public ErrorDetail getError() {
		return error;
	}

	@Override
	public void setError(final ErrorDetail error) {
		this.error = error;
	}

}
