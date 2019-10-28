/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.bordertech.swagger.test;

import com.github.bordertech.lde.api.LdeLauncher;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * RestAssured API tests for AttachmentViewerApi.
 */
public class Jersey1ApiTest {

	@BeforeClass
	public static void startTomcat() {
		LdeLauncher.launchServer(false);
	}

	@AfterClass
	public static void closeTomcat() {
		LdeLauncher.stopServer();
	}

	@Before
	public void configRestAssured() {
		RestAssured.baseURI = LdeLauncher.getProvider().getBaseUrl();
		RestAssured.port = LdeLauncher.getProvider().getPort();
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
	public void testGetBusinessException() {
		RestAssured.given()
				.log().all()
				.queryParam("echo", "bus")
				.when()
				.get("/api/v1/tests")
				.then()
				.assertThat()
				.statusCode(400);
	}

	@Test
	public void testGetSystemException() {
		RestAssured.given()
				.log().all()
				.queryParam("echo", "sys")
				.when()
				.get("/api/v1/tests")
				.then()
				.assertThat()
				.statusCode(500);
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
