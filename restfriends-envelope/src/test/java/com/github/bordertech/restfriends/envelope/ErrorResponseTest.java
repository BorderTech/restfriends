package com.github.bordertech.restfriends.envelope;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 * Unit test for {@link ErrorResponse}.
 */
public class ErrorResponseTest {

	@Test
	public void constructorTest1() {

		ErrorResponse errorResponse = new ErrorResponse();
		assertThat(errorResponse.getError(), nullValue());
	}

	@Test
	public void constructorTest2() {
		ErrorDetail errorDetail = new ErrorDetail();
		ErrorResponse errorResponse = new ErrorResponse(errorDetail);
		assertThat(errorResponse.getError(), sameInstance(errorDetail));
	}

	@Test
	public void fieldTest() {
		ErrorDetail errorDetail = new ErrorDetail();
		ErrorResponse errorResponse = new ErrorResponse();
		assertThat(errorResponse.getError(), nullValue());
		errorResponse.setError(errorDetail);
		assertThat(errorResponse.getError(), sameInstance(errorDetail));
	}

}
