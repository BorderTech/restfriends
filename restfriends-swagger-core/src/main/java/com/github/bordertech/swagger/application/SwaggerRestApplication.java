package com.github.bordertech.swagger.application;

import com.github.bordertech.swagger.handler.ExceptionHandler;
import com.github.bordertech.swagger.handler.RestBusinessExceptionHandler;
import com.github.bordertech.swagger.handler.RestSystemExceptionHandler;
import io.swagger.jaxrs.listing.AcceptHeaderApiListingResource;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Configure Swagger REST Application.
 * <p>
 * Projects extend this class to define project specific resources.
 * </p>
 */
public class SwaggerRestApplication extends Application {

	private final Set<Class<?>> applClazzes;

	/**
	 * Default constructor.
	 */
	public SwaggerRestApplication() {
		this.applClazzes = Collections.emptySet();
	}

	/**
	 * @param clazzes resources and provider classes
	 */
	public SwaggerRestApplication(final Class... clazzes) {
		applClazzes = new HashSet<>();
		for (Class clazz : clazzes) {
			applClazzes.add(clazz);
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		// Add swagger resources
		resources.add(AcceptHeaderApiListingResource.class);
		resources.add(ApiListingResource.class);
		resources.add(SwaggerSerializers.class);
		// Add exception handlers
		resources.addAll(getExceptionMapperClasses());
		// Add application specific classes
		resources.addAll(applClazzes);
		return resources;
	}

	/**
	 * Projects can override default exception mapper classes.
	 *
	 * @return list of exception mapper classes
	 */
	public Collection<Class<?>> getExceptionMapperClasses() {
		return Arrays.asList(RestSystemExceptionHandler.class, RestBusinessExceptionHandler.class, ExceptionHandler.class);
	}

}
