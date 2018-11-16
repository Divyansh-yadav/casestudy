package com.impetus.ogos.exception;

/** This is Rest Exception class.
 * 
 * @author Pawan Nerkar */
public class RestException extends RuntimeException {
    /**
     * Default Version ID.
     */
    private static final long serialVersionUID = 8034943726739094114L;

    /** Parameterized Constructor.
     * 
     * @param message
     *            exception message to print. */
    public RestException(String message) {
        super(message);
    }

    /** Parameterized Constructor.
     * 
     * @param message
     *            exception message to print.
     * @param throwable
     *            exception object. */
    public RestException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
