package com.github.bordertech.restfriends.cors;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * Sample CORS JAXRS Response Filter.
 */
public class SampleCorsResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext) throws IOException {
		if (CorsProperties.isCorsEnabled()) {
			configCorsHeaders(responseContext);
		}
	}

	/**
	 * Configure CORS Headers.
	 *
	 * @param responseContext the response context to set the CORS headers on
	 */
	protected void configCorsHeaders(final ContainerResponseContext responseContext) {
		// Set CORS Headers
		responseContext.getHeaders().add("Access-Control-Allow-Origin", CorsProperties.getAllowOrigin());
		responseContext.getHeaders().add("Access-Control-Allow-Credentials", CorsProperties.getAllowCredentials());
		responseContext.getHeaders().add("Access-Control-Allow-Headers", CorsProperties.getAllowHeaders());
		responseContext.getHeaders().add("Access-Control-Allow-Methods", CorsProperties.getAllowMethods());
	}

}
