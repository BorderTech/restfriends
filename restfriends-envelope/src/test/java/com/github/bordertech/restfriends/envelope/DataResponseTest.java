package com.github.bordertech.restfriends.envelope;

import java.io.Serializable;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 * Unit test for {@link DataResponse}.
 */
public class DataResponseTest {

	@Test
	public void constructorTest() {
		DummyObject dummyObject = new DummyObject();
		DataResponse dataResponse = new DataResponse(dummyObject);
		assertThat(dataResponse.getData(), sameInstance(dummyObject));
	}

	@Test
	public void fieldTest() {
		DummyObject dummyObject = new DummyObject();
		DataResponse dataResponse = new DataResponse();
		assertThat(dataResponse.getData(), nullValue());
		dataResponse.setData(dummyObject);
		assertThat(dataResponse.getData(), sameInstance(dummyObject));
	}

	private class DummyObject implements Serializable {

	}

}
