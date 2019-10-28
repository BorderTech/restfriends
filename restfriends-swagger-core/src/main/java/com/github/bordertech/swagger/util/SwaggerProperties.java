package com.github.bordertech.swagger.util;

import com.github.bordertech.config.Config;

/**
 * Swagger properties helper class.
 */
public final class SwaggerProperties {

	/**
	 * Private constructor.
	 */
	private SwaggerProperties() {
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
		return Config.getInstance().getString("bordertech.swagger.ui.path", "swaggerui");
	}

	/**
	 * @return the swagger UI parameters to include on swagger UI URL
	 */
	public static String getSwaggerUiParams() {
		return Config.getInstance().getString("bordertech.swagger.ui.params", "&operationsSorter=alpha");
	}

	/**
	 * @return the default HOST path, or null if build dynamically
	 */
	public static String getHostPath() {
		return Config.getInstance().getString("bordertech.swagger.host.path");
	}

}
