package com.github.bordertech.swagger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Redirect to the static swagger ui with the API location details.
 */
@WebServlet(urlPatterns = "/launchswagger", loadOnStartup = 3)
public class SwaggerUiRedirectServlet extends HttpServlet {

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		String redirect = buildRedirectUiPath(req);
		resp.sendRedirect(redirect);
	}

	/**
	 * Build the URL to the static swagger UI with the swagger API details in the query string.
	 *
	 * @param req the request being processed
	 * @return the path to redirect to the swagger UI
	 */
	protected String buildRedirectUiPath(final HttpServletRequest req) {
		String ctx = req.getServletContext().getContextPath();
		String uiPath = PathUtil.prefixUrl(ctx, SwaggerPathConfig.getSwaggerUiPath());
		String apiPath = PathUtil.prefixUrl(ctx, SwaggerPathConfig.getApiPath());
		return uiPath + "/index.html?url=" + apiPath + "/swagger";
	}

}
