package com.yieldbroker.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class YieldBrokerBusinessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6091839655693191081L;

	public YieldBrokerBusinessException(String string) {
		super(string);
	}
}