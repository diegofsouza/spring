package com.spring.json;

import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CustomGsonHttpMessageConverter extends GsonHttpMessageConverter {
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	public CustomGsonHttpMessageConverter() {
		super();
		super.setGson(this.customGson());

	}

	private Gson customGson() {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat(DATE_FORMAT);

		return builder.create();
	}
}
