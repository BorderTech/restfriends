package com.github.bordertech.swagger.servlet;

import com.github.bordertech.swagger.util.PathUtil;
import com.github.bordertech.swagger.util.SwaggerProperties;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Redirect to the static swagger ui with the API location details.
 * <p>
 * Applications can add this servlet to help launch the swagger UI configured with API details.
 * </p>
 */
public class SwaggerUiLaunchServlet extends HttpServlet {

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		String redirect = buildRedirectUiPath(req);
		try {
			resp.sendRedirect(redirect);
		} catch (IOException e) {
			throw new IllegalStateException("Could not redirect to swagger ui.", e);
		}
	}

	/**
	 * Build the URL to the static swagger UI with the swagger API details in the query string.
	 *
	 * @param req the request being processed
	 * @return the path to redirect to the swagger UI
	 */
	protected String buildRedirectUiPath(final HttpServletRequest req) {
		String ctx = req.getServletContext().getContextPath();
		String uiPath = PathUtil.prefixUrl(ctx, SwaggerProperties.getSwaggerUiPath());
		String apiPath = PathUtil.prefixUrl(ctx, SwaggerProperties.getApiPath());
		String uiParams = SwaggerProperties.getSwaggerUiParams();
		return uiPath + "/index.html?url=" + apiPath + "/swagger" + uiParams;
	}

}
