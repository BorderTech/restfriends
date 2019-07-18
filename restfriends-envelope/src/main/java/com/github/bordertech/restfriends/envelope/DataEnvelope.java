package com.github.bordertech.restfriends.envelope;

import java.io.Serializable;

/**
 * Response envelope that holds data object.
 *
 * @param <T> the data type
 */
public interface DataEnvelope<T extends Serializable> extends Envelope {

	/**
	 * @return the response data
	 */
	T getData();

	/**
	 * @param data the response data
	 */
	void setData(T data);

}
