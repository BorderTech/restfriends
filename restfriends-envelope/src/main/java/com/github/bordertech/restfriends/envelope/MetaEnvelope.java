package com.github.bordertech.restfriends.envelope;

import java.io.Serializable;

/**
 * Response that holds meta data.
 * <p>
 * Can be added to all other response envelopes when needed or used on its own.
 * </p>
 *
 * @param <T> the meta data type
 */
public interface MetaEnvelope<T extends Serializable> extends Envelope {

	/**
	 * @return the response meta data
	 */
	T getMeta();

	/**
	 *
	 * @param meta the response meta data
	 */
	void setMeta(T meta);

}
