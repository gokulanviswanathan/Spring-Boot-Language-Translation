package com.sbt.config;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;

public class AcceptHeaderResolver extends AcceptHeaderLocaleContextResolver {

	List<Locale> defaultLocale = Arrays.asList(new Locale("en"));

	public Locale resolveLocale(HttpServletRequest request) {
		String headerLang = request.getHeader("Accept-Language");
		return headerLang == null || headerLang.isEmpty() ? Locale.getDefault()
				: Locale.lookup(Locale.LanguageRange.parse(headerLang), defaultLocale);
	}

}