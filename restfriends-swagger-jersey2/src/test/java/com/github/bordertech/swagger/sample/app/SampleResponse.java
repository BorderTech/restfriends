package com.github.bordertech.swagger.sample.app;

import com.github.bordertech.restfriends.envelope.DataEnvelope;

/**
 * Test data envelope response.
 */
public class SampleResponse implements DataEnvelope<String> {

	private String data;

	public SampleResponse() {
	}

	public SampleResponse(final String data) {
		this.data = data;
	}

	@Override
	public String getData() {
		return data;
	}

	@Override
	public void setData(final String data) {
		this.data = data;
	}

}
