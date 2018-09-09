package com.yieldbroker.assignment.webservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility for converting objects to JSON.
 * 
 * @author Marvin Alvarez
 */
public class JsonUtil {

	/**
	 * ObjectMapper
	 */
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * Converts any object into a Json String message.
	 * 
	 * @param object
	 * @return
	 */
	public static String convert(Object object) {
		try {
			String writeValueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			return writeValueAsString;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}