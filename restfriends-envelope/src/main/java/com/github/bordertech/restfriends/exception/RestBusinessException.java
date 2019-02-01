package com.github.bordertech.restfriends.exception;

/**
 * Business checked exception.
 */
public class RestBusinessException extends Exception implements RestStatusCodable {

	/**
	 * @param message the exception message
	 * @param ex the original exception
	 */
	public RestBusinessException(final String message, final Exception ex) {
		super(message, ex);
	}

	/**
	 * @param message the exception message
	 */
	public RestBusinessException(final String message) {
		super(message);
	}

	@Override
	public int getStatusCode() {
		return 400;
	}

}
