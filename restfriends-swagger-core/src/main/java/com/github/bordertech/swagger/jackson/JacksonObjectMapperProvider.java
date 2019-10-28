package com.github.bordertech.swagger.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.github.bordertech.swagger.application.SwaggerRestApplication;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Jackson object mapper.
 * <p>
 * This provider can be added to the Application classes to provide different defaults to Jackson.
 * </p>
 *
 * @see SwaggerRestApplication
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {

	private final ObjectMapper defaultObjectMapper;

	/**
	 * Default constructor.
	 */
	public JacksonObjectMapperProvider() {
		defaultObjectMapper = createDefaultMapper();
	}

	@Override
	public ObjectMapper getContext(final Class<?> type) {
		return defaultObjectMapper;
	}

	/**
	 * @return the default mapper
	 */
	public static ObjectMapper createDefaultMapper() {
		final ObjectMapper jackson = new ObjectMapper();
		// Use JODA for Timestamp Formatting
		jackson.registerModule(new JodaModule());
		jackson.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		// Prevent exception when encountering unknown property:
		jackson.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return jackson;
	}
}
