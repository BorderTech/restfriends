package com.github.bordertech.swagger.servlet;

import org.apache.commons.lang3.StringUtils;

/**
 * Path helper class.
 */
public final class PathUtil {

	/**
	 * Private constructor.
	 */
	private PathUtil() {
	}

	/**
	 * Combine a base path and relative path URL.
	 * <p>
	 * An empty or null base path is treated as root "/".
	 * </p>
	 *
	 * @param basePath the base URL
	 * @param relativePath the relative URL
	 * @return the base path appended to the relative URL
	 */
	public static String prefixUrl(final String basePath, final String relativePath) {

		String prefix = StringUtils.isBlank(basePath) ? "/" : basePath;

		boolean prefixHas = prefix.endsWith("/");
		boolean relativeHas = relativePath.startsWith("/");

		StringBuilder result = new StringBuilder(prefix);
		// Both have a dash
		if (prefixHas && relativeHas) {
			// Remove dash
			result.append(relativePath.substring(1));
		} else if (!prefixHas && !relativeHas) {
			// Add a dash
			result.append("/");
			result.append(relativePath);
		} else {
			result.append(relativePath);
		}
		return result.toString();
	}

}
