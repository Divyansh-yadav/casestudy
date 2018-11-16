package com.impetus.ogos.exception;

/**
 * It is custom DaoException Class which is extending exception class.
 *
 */
public class DaoException extends Exception {

	/**
	 * A unique serial version identifier.
	 */
	private static final long serialVersionUID = 3478684559738841675L;

	/**
	 * Non parameterized constructor.
	 */
	public DaoException() {
		super();
	}

	/**
	 * parameterized constructor.
	 * 
	 * @param errorMessage type of string which is taking the errormessage
	 */
	public DaoException(String errorMessage) {
		super(errorMessage);
	}
	
	 /** Parameterized Constructor.
     * 
     * @param message
     *            exception message to print.
     * @param throwable
     *            exception object. */
	 public DaoException(String message, Throwable throwable) {
	        super(message, throwable);
	    }
}
