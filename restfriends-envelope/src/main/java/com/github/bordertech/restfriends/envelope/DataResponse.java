package com.github.bordertech.restfriends.envelope;

import java.io.Serializable;

/**
 * Service response with meta data, data and error. `
 *
 * @param <T> the data type in the response
 */
public class DataResponse<T extends Serializable> extends BasicResponse {

	private T data;

	/**
	 * Protected default constructor.
	 */
	protected DataResponse() {
		this.data = null;
	}

	/**
	 * @param data response data
	 */
	public DataResponse(final T data) {
		this.data = data;
	}

	/**
	 * @return the response data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the response data
	 */
	public void setData(final T data) {
		this.data = data;
	}

}
