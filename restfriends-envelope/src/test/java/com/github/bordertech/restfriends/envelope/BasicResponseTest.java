package com.github.bordertech.restfriends.envelope;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Unit test for {@link BasicResponse}.
 */
public class BasicResponseTest {

	@Test
	public void fieldTest() {
		BasicResponse basicResponse = new BasicResponse();
		DummyMetaData metaData = new DummyMetaData();
		basicResponse.setMeta(metaData);
		MatcherAssert.assertThat(basicResponse.getMeta(), CoreMatchers.sameInstance(metaData));
	}

	private class DummyMetaData implements MetaData {

	}

}
