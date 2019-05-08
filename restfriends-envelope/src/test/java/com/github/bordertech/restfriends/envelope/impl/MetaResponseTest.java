package com.github.bordertech.restfriends.envelope.impl;

import java.io.Serializable;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Unit test for {@link BasicResponse}.
 */
public class MetaResponseTest {

	@Test
	public void fieldTest() {
		MetaResponse basicResponse = new MetaResponse();
		DummyMetaData metaData = new DummyMetaData();
		basicResponse.setMeta(metaData);
		MatcherAssert.assertThat(basicResponse.getMeta(), CoreMatchers.sameInstance(metaData));
	}

	private class DummyMetaData implements Serializable {

	}

}
