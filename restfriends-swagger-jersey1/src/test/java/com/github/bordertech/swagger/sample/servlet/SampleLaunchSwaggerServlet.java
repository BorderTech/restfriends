package com.github.bordertech.swagger.sample.servlet;

import com.github.bordertech.swagger.servlet.SwaggerUiLaunchServlet;
import javax.servlet.annotation.WebServlet;

/**
 * Launch swagger.
 */
@WebServlet(urlPatterns = "/launchswagger", loadOnStartup = 3)
public class SampleLaunchSwaggerServlet extends SwaggerUiLaunchServlet {

}
