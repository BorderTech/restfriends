package com.github.bordertech.swagger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Redirect to the swagger ui allowing for the relative base.
 */
@WebServlet(urlPatterns = "/launchswagger", loadOnStartup = 3)
public class SwaggerUiRedirectServlet extends HttpServlet {

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		// Assumes SwaggerUtil has been initialised via the swagger servlet
		// Redirect to the swagger UI with the correct API path
		resp.sendRedirect(SwaggerPathUtil.getUiRedirectUrl());
	}

}
