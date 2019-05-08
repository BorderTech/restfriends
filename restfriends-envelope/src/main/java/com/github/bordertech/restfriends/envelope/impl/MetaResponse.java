package com.github.bordertech.restfriends.envelope.impl;

import com.github.bordertech.restfriends.envelope.MetaEnvelope;
import java.io.Serializable;

/**
 * Service response with only meta data. `
 *
 * @param <T> the meta type
 */
public class MetaResponse<T extends Serializable> implements MetaEnvelope<T> {

	private T meta;

	/**
	 * Protected default constructor (used by libraries like jaxb).
	 */
	protected MetaResponse() {
		this.meta = null;
	}

	/**
	 * @param meta the meta data
	 */
	public MetaResponse(final T meta) {
		this.meta = meta;
	}

	@Override
	public T getMeta() {
		return meta;
	}

	@Override
	public void setMeta(final T meta) {
		this.meta = meta;
	}
}
