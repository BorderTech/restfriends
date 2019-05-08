package com.github.bordertech.restfriends.envelope;

/**
 * Response envelope that holds error details.
 */
public interface ErrorEnvelope extends Envelope {

	/**
	 * @return the error detail
	 */
	ErrorDetail getError();

	/**
	 * @param error the error detail
	 */
	void setError(ErrorDetail error);

}
