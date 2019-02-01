package com.github.bordertech.restfriends.exception;

/**
 * System unchecked exception.
 */
public class RestSystemException extends RuntimeException implements RestStatusCodable {

	/**
	 * @param message the exception message
	 * @param ex the original exception
	 */
	public RestSystemException(final String message, final Exception ex) {
		super(message, ex);
	}

	/**
	 * @param message the exception message
	 */
	public RestSystemException(final String message) {
		super(message);
	}

	@Override
	public int getStatusCode() {
		return 500;
	}

}
