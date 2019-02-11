package com.github.bordertech.swagger.servlet;

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
	 * Combine a base bath and relative URL.
	 *
	 * @param prefix the prefix for the URL
	 * @param relativeUrl the relative URL
	 * @return the prefix appended to the relative URL
	 */
	public static String prefixUrl(final String prefix, final String relativeUrl) {
		if (prefix == null || prefix.isEmpty()) {
			return relativeUrl;
		}

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
