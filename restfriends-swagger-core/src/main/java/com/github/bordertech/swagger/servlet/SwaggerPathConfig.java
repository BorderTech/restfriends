package com.github.bordertech.swagger.servlet;

import com.github.bordertech.config.Config;

/**
 * Swagger path configuration helper class.
 */
public final class SwaggerPathConfig {

	/**
	 * Private constructor.
	 */
	private SwaggerPathConfig() {
	}

	/**
	 * @return the default API path which is used in the swagger JSON
	 */
	public static String getApiPath() {
		return Config.getInstance().getString("bordertech.swagger.api.path", "api");
	}

	/**
	 * @return the default swagger UI path
	 */
	public static String getSwaggerUiPath() {
		return Config.getInstance().getString("bordertech.swagger.ui.path", "swagger-ui");
	}

	/**
	 * @return the default HOST path, or null if build dynamically
	 */
	public static String getHostPath() {
		return Config.getInstance().getString("bordertech.swagger.host.path");
	}

}
