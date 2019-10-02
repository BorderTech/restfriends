package com.github.bordertech.restfriends.cors;

import com.github.bordertech.config.Config;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link CorsProperties}.
 */
public class CorsProperties_Tests {

	private static final String PREFIX = "bordertech.restfriends.cors.";

	@After
	public void afterTest() {
		Config.reset();
	}

	@Test
	public void testCorsEnabled() {
		Assert.assertTrue("CORS enabled should default to true", CorsProperties.isCorsEnabled());
	}

	@Test
	public void testCorsDisabled() {
		Config.getInstance().addProperty(PREFIX + "enabled", false);
		Assert.assertFalse("CORS should be disabled", CorsProperties.isCorsEnabled());
	}

	@Test
	public void testCorsOriginDefault() {
		Assert.assertNotNull("No default set for Origin", CorsProperties.getAllowOrigin());
	}

	@Test
	public void testCorsOriginUpdated() {
		String override = "MYORIGIN";
		Config.getInstance().addProperty(PREFIX + "allow.origin", override);
		Assert.assertEquals("Incorrect override value for origin", override, CorsProperties.getAllowOrigin());
	}

	@Test
	public void testCorsCredentialsDefault() {
		Assert.assertNotNull("No default set for Credentials", CorsProperties.getAllowCredentials());
	}

	@Test
	public void testCorsCredentialsUpdated() {
		String override = "MYCRED";
		Config.getInstance().addProperty(PREFIX + "allow.credentials", override);
		Assert.assertEquals("Incorrect override value for credentials", override, CorsProperties.getAllowCredentials());
	}

	@Test
	public void testCorsHeadersDefault() {
		Assert.assertNotNull("No default set for Headers", CorsProperties.getAllowHeaders());
	}

	@Test
	public void testCorsHeadersUpdated() {
		String override = "MYHEADERS";
		Config.getInstance().addProperty(PREFIX + "allow.headers", override);
		Assert.assertEquals("Incorrect override value for headers", override, CorsProperties.getAllowHeaders());
	}

	@Test
	public void testCorsMethodsDefault() {
		Assert.assertNotNull("No default set for methods", CorsProperties.getAllowMethods());
	}

	@Test
	public void testCorsMethodsUpdated() {
		String override = "MYMETHODS";
		Config.getInstance().addProperty(PREFIX + "allow.methods", override);
		Assert.assertEquals("Incorrect override value for methods", override, CorsProperties.getAllowMethods());
	}

}
