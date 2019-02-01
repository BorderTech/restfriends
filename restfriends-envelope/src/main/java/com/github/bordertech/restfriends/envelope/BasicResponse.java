package com.github.bordertech.restfriends.envelope;

import java.io.Serializable;

/**
 * Service response with meta data and error. `
 */
public class BasicResponse implements Serializable {

	private MetaData meta;

	/**
	 * @return the response meta data
	 */
	public MetaData getMeta() {
		return meta;
	}

	/**
	 * @param meta the response meta data
	 */
	public void setMeta(final MetaData meta) {
		this.meta = meta;
	}
}
