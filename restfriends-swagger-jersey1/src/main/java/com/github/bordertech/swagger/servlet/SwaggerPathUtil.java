package com.github.bordertech.swagger.servlet;

import com.github.bordertech.config.Config;
import javax.servlet.ServletConfig;

/**
 * Swagger path helper class.
 */
public final class SwaggerPathUtil {

	/**
	 * Private constructor.
	 */
	private SwaggerPathUtil() {
	}

	private static final String HOST_PARAM = "bordertech.swagger.api.host";
	private static final String API_PATH_PARAM = "bordertech.swagger.api.path";
	private static final String UI_PATH_PARAM = "bordertech.swagger.ui.path";

	private static String initHost = null;
	private static String initAPIPath = null;
	private static String initUIPath = null;
	private static String context = "";

	/**
	 * This method should be called when the servlet is initialised.
	 *
	 * @param servletConfig the servlet config.
	 */
	public static void initPaths(final ServletConfig servletConfig) {
		initHost = servletConfig.getInitParameter(HOST_PARAM);
		initAPIPath = servletConfig.getInitParameter(API_PATH_PARAM);
		initUIPath = servletConfig.getInitParameter(UI_PATH_PARAM);
		context = servletConfig.getServletContext().getContextPath();
	}

	/**
	 * @return the API host path
	 */
	public static String getHost() {
		return initHost == null ? getDefaultHost() : initHost;
	}

	/**
	 * @return the API path
	 */
	public static String getApiPath() {
		String path = initAPIPath == null ? getDefaultApiPath() : initAPIPath;
		return baseUrl(path);
	}

	/**
	 * @return the path to the swagger UI
	 */
	public static String getUiPath() {
		String path = initUIPath == null ? getDefaultUiPath() : initUIPath;
		return baseUrl(path);
	}

	/**
	 * @return the path to redirect to the swagger UI
	 */
	public static String getUiRedirectUrl() {
		return getUiPath() + "/index.html?url=" + getApiPath() + "/swagger";
	}

	/**
	 * @return the default host
	 */
	private static String getDefaultHost() {
		return Config.getInstance().getString(HOST_PARAM, "localhost:8080");
	}

	/**
	 * @return the default API path
	 */
	private static String getDefaultApiPath() {
		return Config.getInstance().getString(API_PATH_PARAM, "api");
	}

	/**
	 * @return the default swagger UI path
	 */
	private static String getDefaultUiPath() {
		return Config.getInstance().getString(UI_PATH_PARAM, "swagger-ui");
	}

	/**
	 * @param relativeUrl the relative URL
	 * @return the relative URL appended to the base URL.
	 */
	private static String baseUrl(final String relativeUrl) {
		if (context == null || context.isEmpty()) {
			return relativeUrl;
		} else {
			return prefixUrl(context, relativeUrl);
		}
	}

	/**
	 *
	 * @param prefix the prefix for the URL
	 * @param relativeUrl the relative URL
	 * @return the prefix appended to the relative URL
	 */
	private static String prefixUrl(final String prefix, final String relativeUrl) {
		boolean prefixHas = prefix.endsWith("/");
		boolean relativeHas = relativeUrl.startsWith("/");

		StringBuilder result = new StringBuilder();
		result.append(prefix);
		// Both have a dash
		if (prefixHas && relativeHas) {
			// Remove dash
			result.append(relativeUrl.substring(1));
		} else if (!prefixHas && !relativeHas) {
			// Add a dash
			result.append("/");
			result.append(relativeUrl);
		} else {
			result.append(relativeUrl);
		}
		return result.toString();
	}

}
