package com.github.bordertech.restfriends.envelope;

/**
 * Service error response with meta data and error details. `
 */
public class ErrorResponse extends BasicResponse {

	private ErrorDetail error;

	/**
	 * Protected default constructor.
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

	/**
	 * @return the error detail
	 */
	public ErrorDetail getError() {
		return error;
	}

	/**
	 * @param error the error detail
	 */
	public void setError(final ErrorDetail error) {
		this.error = error;
	}

}
