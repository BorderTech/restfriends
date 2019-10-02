package com.github.bordertech.restfriends.cors;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Sample CORS Servlet filter.
 */
public class SampleCorsServletFilter implements Filter {

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
		if (CorsProperties.isCorsEnabled()) {
			HttpServletResponse res = (HttpServletResponse) response;
			configCorsHeaders(res);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Do nothing
	}

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		// Do nothing
	}

	/**
	 * Configure CORS Headers.
	 *
	 * @param response the response to set the CORS headers on
	 */
	protected void configCorsHeaders(final HttpServletResponse response) {
		// Set CORS Headers
		response.addHeader("Access-Control-Allow-Origin", CorsProperties.getAllowOrigin());
		response.addHeader("Access-Control-Allow-Credentials", CorsProperties.getAllowCredentials());
		response.addHeader("Access-Control-Allow-Headers", CorsProperties.getAllowHeaders());
		response.addHeader("Access-Control-Allow-Methods", CorsProperties.getAllowMethods());
	}

}
