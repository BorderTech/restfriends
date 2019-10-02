package com.github.bordertech.restfriends.cors;

import com.github.bordertech.config.Config;
import org.apache.commons.configuration.Configuration;

/**
 * CORS runtime properties.
 */
public final class CorsProperties {

	private static final String PREFIX = "bordertech.restfriends.cors.";

	/**
	 * Prevent instantiation.
	 */
	private CorsProperties() {
		// Do nothing
	}

	/**
	 * @return true if CORS enabled
	 */
	public static boolean isCorsEnabled() {
		return getConfig().getBoolean(PREFIX + "enabled", true);
	}

	/**
	 * @return the space delimited list of allowed origins or * for any
	 */
	public static String getAllowOrigin() {
		return getConfig().getString(PREFIX + "allow.origin", "*");
	}

	/**
	 * @return the allow credentials value
	 */
	public static String getAllowCredentials() {
		return getConfig().getString(PREFIX + "allow.credentials", "true");
	}

	/**
	 * @return the allow headers value
	 */
	public static String getAllowHeaders() {
		return getConfig().getString(PREFIX + "allow.headers", "origin, content-type, accept, authorization");
	}

	/**
	 * @return the allow methods value
	 */
	public static String getAllowMethods() {
		return getConfig().getString(PREFIX + "allow.methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}

	/**
	 * @return the config instance
	 */
	private static Configuration getConfig() {
		return Config.getInstance();
	}

}
