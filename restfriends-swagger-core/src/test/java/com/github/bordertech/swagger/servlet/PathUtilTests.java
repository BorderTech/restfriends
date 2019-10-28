package com.github.bordertech.swagger.servlet;

import com.github.bordertech.swagger.util.PathUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link PathUtil}.
 */
public class PathUtilTests {

	@Test
	public void testPrefixUrl() {
		String path = PathUtil.prefixUrl("base", "rel");
		Assert.assertEquals("In correct path returned", "/base/rel", path);
	}

	@Test
	public void testPrefixUrlNullBase() {
		String path = PathUtil.prefixUrl(null, "rel");
		Assert.assertEquals("In correct path returned for null base", "/rel", path);
	}

	@Test
	public void testPrefixUrlEmptyBase() {
		String path = PathUtil.prefixUrl("", "rel");
		Assert.assertEquals("In correct path returned for empty base", "/rel", path);
	}

	@Test
	public void testPrefixUrlNullRelative() {
		String path = PathUtil.prefixUrl("base", null);
		Assert.assertEquals("In correct path returned for null relative", "/base", path);
	}

	@Test
	public void testPrefixUrlEmptyRelative() {
		String path = PathUtil.prefixUrl("base", "");
		Assert.assertEquals("In correct path returned for empty relative", "/base", path);
	}

	@Test
	public void testPrefixUrlBothNull() {
		String path = PathUtil.prefixUrl(null, null);
		Assert.assertEquals("In correct path returned for both null", "/", path);
	}

	@Test
	public void testPrefixUrlBothEmpty() {
		String path = PathUtil.prefixUrl("", "");
		Assert.assertEquals("In correct path returned for both empty", "/", path);
	}

	@Test
	public void testPrefixUrlBaseHasSeperator() {
		String path = PathUtil.prefixUrl("base/", "rel");
		Assert.assertEquals("In correct path returned for base has seperator", "/base/rel", path);
	}

	public void testPrefixUrlRelativeHasSeperator() {
		String path = PathUtil.prefixUrl("base", "/rel");
		Assert.assertEquals("In correct path returned for relative has seperator", "/base/rel", path);
	}

	public void testPrefixUrlBothHaveSeperator() {
		String path = PathUtil.prefixUrl("base/", "/rel");
		Assert.assertEquals("In correct path returned for both have seperators", "/base/rel", path);
	}

	public void testPrefixUrlBothSeperators() {
		String path = PathUtil.prefixUrl("/", "/");
		Assert.assertEquals("In correct path returned for both are seperators", "/", path);
	}

	public void testPrefixUrlBaseSeperator() {
		String path = PathUtil.prefixUrl("/", null);
		Assert.assertEquals("In correct path returned for base only seperator", "/", path);
	}

	public void testPrefixUrlRelSeperators() {
		String path = PathUtil.prefixUrl(null, "/");
		Assert.assertEquals("In correct path returned for relative only seperators", "/", path);
	}

}
