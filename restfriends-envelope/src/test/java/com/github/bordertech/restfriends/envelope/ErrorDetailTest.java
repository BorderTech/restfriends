package com.github.bordertech.restfriends.envelope;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 * Unit test for {@link ErrorDetail}.
 */
public class ErrorDetailTest {

	@Test
	public void constructorTest1() {

		ErrorDetail errorDetail = new ErrorDetail();
		assertThat(errorDetail.getStatus(), equalTo(0));
		assertThat(errorDetail.getMessage(), nullValue());
		assertThat(errorDetail.getMoreInfoUrl(), nullValue());
	}

	@Test
	public void constructorTest2() {

		ErrorDetail errorDetail = new ErrorDetail(10, "message");
		assertThat(errorDetail.getStatus(), equalTo(10));
		assertThat(errorDetail.getMessage(), equalTo("message"));
		assertThat(errorDetail.getMoreInfoUrl(), nullValue());
	}

	@Test
	public void constructorTest3() {

		ErrorDetail errorDetail = new ErrorDetail(10, "message", "moreInfoURL");
		assertThat(errorDetail.getStatus(), equalTo(10));
		assertThat(errorDetail.getMessage(), equalTo("message"));
		assertThat(errorDetail.getMoreInfoUrl(), equalTo("moreInfoURL"));
	}

}
