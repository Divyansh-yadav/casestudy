package com.impetus.ogos.exception;

/**
 * Exception class for catching incorrect input.
 * 
 * @author pawan.nerker
 *
 */
public class InputValidationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/** Default Constructor. */
	public InputValidationException() {
		super();
	}

	/**
	 * Parameterized Constructor.
	 * 
	 * @param message   exception message to print.
	 * @param throwable exception object.
	 */
	public InputValidationException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Parameterized Constructor.
	 * 
	 * @param message exception message to print.
	 */
	public InputValidationException(String message) {
		super(message);
	}
}
