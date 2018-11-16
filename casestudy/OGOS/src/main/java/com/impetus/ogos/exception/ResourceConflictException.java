package com.impetus.ogos.exception;

/** Exception class for catching entity already exist exception.
 * 
 * @author Pawan Nerkar */
public class ResourceConflictException extends RuntimeException {
    /** Serial Version ID. */
    private static final long serialVersionUID = -6043680582098167490L;

    /** Default Constructor. */
    public ResourceConflictException() {
        super();
    }

    /** Parameterized Constructor.
     * 
     * @param message
     *            exception message to print. */
    public ResourceConflictException(String message) {
        super(message);
    }

    /** Parameterized Constructor.
     * 
     * @param message
     *            exception message to print.
     * @param throwable
     *            exception object. */
    public ResourceConflictException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
