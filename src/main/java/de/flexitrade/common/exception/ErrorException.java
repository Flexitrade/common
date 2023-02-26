package de.flexitrade.common.exception;

import org.slf4j.Logger;

public class ErrorException extends Exception {
	private static final long serialVersionUID = -2387506419086402771L;
	private final String message;
	
	public ErrorException(Logger logger, String message, Throwable e) {
		this.message = message;
		logger.error(message + ":" + e.getStackTrace().toString());
	}

	public ErrorException(Logger logger, String message) {
		this.message = message;
		logger.error(message);
	}

}
