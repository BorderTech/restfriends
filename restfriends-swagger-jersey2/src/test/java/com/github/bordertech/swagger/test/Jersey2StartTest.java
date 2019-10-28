package com.github.bordertech.swagger.test;

import com.github.bordertech.lde.api.LdeLauncher;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Jersey and Swagger start correctly.
 */
public class Jersey2StartTest {

	@Before
	public void startTomcat() {
		LdeLauncher.launchServer(false);
		RestAssured.baseURI = LdeLauncher.getProvider().getBaseUrl();
		RestAssured.port = LdeLauncher.getProvider().getPort();
	}

	@After
	public void closeTomcat() {
		LdeLauncher.stopServer();
	}

	@Test
	public void testGetEcho() {
		String value = "mytest";
		RestAssured.given()
				.log().all()
				.queryParam("echo", value)
				.when()
				.get("/api/v1/tests")
				.then()
				.assertThat()
				.statusCode(200)
				.and()
				.contentType(ContentType.JSON)
				.body("data", IsEqual.equalTo(value));
	}

	@Test
	public void testLaunchSwagger() {
		RestAssured.given().
				log().all()
				.when()
				.get("/launchswagger")
				.then()
				.assertThat()
				.statusCode(200)
				.and()
				.contentType(ContentType.HTML)
				.body("html.head.title", IsEqual.equalTo("Swagger UI"));
	}
}
