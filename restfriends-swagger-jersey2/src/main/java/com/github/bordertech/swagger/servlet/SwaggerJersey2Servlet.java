package com.github.bordertech.swagger.servlet;

import com.github.bordertech.swagger.util.SwaggerProperties;
import com.github.bordertech.swagger.util.PathUtil;
import com.github.bordertech.swagger.application.SwaggerRestApplication;
import io.swagger.config.SwaggerConfig;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Swagger;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Jersey servlet that configures swagger.
 * <p>
 * Applications extend this class and define it as a webservlet.
 * </p>
 * <p>
 * Set the following init parameters:-
 * </p>
 * <ul>
 * <li> {@code com.sun.jersey.api.json.POJOMappingFeature} = {@code true} to enable JSON.</li>
 * <li> {@code javax.ws.rs.Application} = {@code com.example.MySwaggerRestApplication}. This is the projects
 * implementation of {@link SwaggerRestApplication}.
 * </li>
 * </ul>
 *
 * @see SwaggerRestApplication
 */
public class SwaggerJersey2Servlet extends ServletContainer {

	private String host;
	private String apiPath;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		configSwagger();
		// Application context
		String context = config.getServletContext().getContextPath();
		// Set API path
		apiPath = PathUtil.prefixUrl(context, SwaggerProperties.getApiPath());
		// Check if HOST has been set via properties
		host = SwaggerProperties.getHostPath();
	}

	/**
	 * Configure swagger HOST and API paths.
	 */
	protected void configSwagger() {
		SwaggerConfig swaggerConfig = new SwaggerConfig() {
			@Override
			public Swagger configure(final Swagger swagger) {
				swagger.setHost(getHost());
				swagger.setBasePath(getApiPath());
				return swagger;
			}

			@Override
			public String getFilterClass() {
				return null;
			}
		};
		// Configure swagger
		new SwaggerContextService().withSwaggerConfig(swaggerConfig).initConfig().initScanner();
	}

	@Override
	public void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		configHostDetails(request);
		super.service(request, response);
	}

	/**
	 * @return the host
	 */
	protected String getHost() {
		return host;
	}

	/**
	 * @return the API path
	 */
	protected String getApiPath() {
		return apiPath;
	}

	/**
	 * @param request the request being processed
	 */
	protected void configHostDetails(final HttpServletRequest request) {
		if (StringUtils.isEmpty(host)) {
			// Dynamically build the HOST details (allow for application context)
			StringBuilder builder = new StringBuilder(request.getServerName());
			builder.append(":");
			builder.append(request.getServerPort());
			host = builder.toString();
		}
	}

}
