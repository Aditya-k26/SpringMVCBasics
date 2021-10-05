package com.registration.login.app.exceptions;

public class ExcessFailedTriesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcessFailedTriesException(String message) {
		super(message);
	}

}
