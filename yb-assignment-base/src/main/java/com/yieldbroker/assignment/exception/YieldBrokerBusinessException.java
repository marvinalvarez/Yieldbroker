package com.yieldbroker.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Runtime exception for Yield Broker application issues.
 * 
 * @author Marvin Alvarez
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class YieldBrokerBusinessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6091839655693191081L;

	/**
	 * Default constructor
	 * 
	 * @param string
	 */
	public YieldBrokerBusinessException(String string) {
		super(string);
	}
}