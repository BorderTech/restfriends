package com.github.bordertech.swagger.servlet;

import io.swagger.config.SwaggerConfig;
import io.swagger.jaxrs.config.ReaderConfigUtils;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Swagger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Sample config servlet. Based on io.swagger.jersey.config.JerseyJaxrsConfig.
 */
@WebServlet(urlPatterns = "/config",
		loadOnStartup = 2,
		initParams
		= {
			// Tell Swagger to scan all resources
			@WebInitParam(name = "scan.all.resources", value = "true")
		}
)
public class SwaggerServlet extends HttpServlet {

	@Override
	public void init(final ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		setupSwagger(servletConfig);
	}

	/**
	 * @param servletConfig the servlet config
	 */
	protected void setupSwagger(final ServletConfig servletConfig) {
		// Initialise the path details
		SwaggerPathUtil.initPaths(servletConfig);
		// Setup the swagger config object
		final String host = SwaggerPathUtil.getHost();
		final String apiPath = SwaggerPathUtil.getApiPath();
		SwaggerConfig config = new SwaggerConfig() {
			@Override
			public Swagger configure(final Swagger swagger) {
				swagger.setHost(host);
				swagger.setBasePath(apiPath);
				return swagger;
			}

			@Override
			public String getFilterClass() {
				return null;
			}
		};
		new SwaggerContextService().withSwaggerConfig(config).initConfig().initScanner();
		ReaderConfigUtils.initReaderConfig(servletConfig);
	}
}
