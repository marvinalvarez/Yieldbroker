package com.yieldbroker.assignment.webservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static String convert(Object object) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String writeValueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			return writeValueAsString;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
