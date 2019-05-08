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
	 * Combine a base path and relative path URL into an absolute path.
	 * <p>
	 * An empty or null base path is treated as root "/".
	 * </p>
	 *
	 * @param basePath the base URL
	 * @param relativePath the relative URL
	 * @return the base path appended to the relative URL
	 */
	public static String prefixUrl(final String basePath, final String relativePath) {

		String prefix = basePath == null ? "" : basePath;
		String suffix = relativePath == null ? "" : relativePath;

		StringBuilder result = new StringBuilder();

		// Always absolute path
		if (!prefix.startsWith("/")) {
			result.append("/");
		}

		// Prefix
		result.append(prefix);

		// Suffix
		if (!StringUtils.isEmpty(suffix)) {
			boolean resultHas = result.charAt(result.length() - 1) == '/';
			boolean suffixHas = suffix.startsWith("/");
			// Both have a dash
			if (resultHas && suffixHas) {
				// Remove dash
				result.append(suffix.substring(1));
			} else if (!resultHas && !suffixHas) {
				// Add a dash
				result.append("/");
				result.append(suffix);
			} else {
				result.append(suffix);
			}
		}

		return result.toString();
	}

}
