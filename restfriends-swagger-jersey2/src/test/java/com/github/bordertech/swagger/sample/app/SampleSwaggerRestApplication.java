package com.github.bordertech.swagger.sample.app;

import com.github.bordertech.swagger.application.SwaggerRestApplication;
import com.github.bordertech.swagger.jackson.JacksonObjectMapperProvider;

/**
 * Test REST Swagger/Jersey Application.
 */
public class SampleSwaggerRestApplication extends SwaggerRestApplication {

	/**
	 * Default constructor.
	 */
	public SampleSwaggerRestApplication() {
		super(SampleApi.class, JacksonObjectMapperProvider.class);
	}
}
