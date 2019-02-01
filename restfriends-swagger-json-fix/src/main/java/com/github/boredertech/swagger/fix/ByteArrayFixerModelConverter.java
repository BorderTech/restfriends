package com.github.boredertech.swagger.fix;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import io.swagger.converter.ModelConverter;
import io.swagger.converter.ModelConverterContext;
import io.swagger.jackson.AbstractModelConverter;
import io.swagger.models.properties.ByteArrayProperty;
import io.swagger.models.properties.Property;
import io.swagger.util.Json;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Iterator;

/**
 * Handle byte[] correctly.
 * <p>
 * There is a known BUG https://github.com/kongchen/swagger-maven-plugin/issues/422.
 * </p>
 */
public class ByteArrayFixerModelConverter extends AbstractModelConverter implements ModelConverter {

	/**
	 * Default constructor.
	 */
	public ByteArrayFixerModelConverter() {
		super(Json.mapper());
	}

	@Override
	public Property resolveProperty(final Type type, final ModelConverterContext context, final Annotation[] annotations,
			final Iterator<ModelConverter> chain) {
		if (isByteArray(type)) {
			//bypass the chain! It would convert the ByteArrayProperty to an Array of ByteArrayProperty (bug in ModelModifier I think)
			return new ByteArrayProperty();
		}
		Property property = null;
		if (chain.hasNext()) {
			property = (chain.next()).resolveProperty(type, context, annotations, chain);
		}

		return property;
	}

	/**
	 * @param type the property type
	 * @return true if a byte array
	 */
	private boolean isByteArray(final Type type) {
		boolean ret = type instanceof Class && type == byte[].class;
		if (!ret && type instanceof ArrayType) {
			ArrayType at = (ArrayType) type;
			JavaType contentType = at.getContentType();
			if (contentType instanceof SimpleType) {
				SimpleType st = (SimpleType) contentType;
				ret = st.getRawClass() == byte.class;
			}
		}
		return ret;
	}
}
