package com.github.bordertech.restfriends.envelope.impl;

import com.github.bordertech.restfriends.envelope.DataEnvelope;
import java.io.Serializable;

/**
 * Service response with data.
 *
 * @param <T> the data type in the response
 */
public class DataResponse<T extends Serializable> implements DataEnvelope<T> {

	private T data;

	/**
	 * Protected default constructor (used by libraries like jaxb).
	 */
	protected DataResponse() {
		this.data = null;
	}

	/**
	 * @param data the response data
	 */
	public DataResponse(final T data) {
		this.data = data;
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(final T data) {
		this.data = data;
	}

}
