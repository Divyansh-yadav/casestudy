package com.impetus.ogos.exception;

/** It is custom ResourceNotFound Class which is extending exception class. */
public class ResourceNotFound extends Exception {
    /** A unique serial version identifier. */
    private static final long serialVersionUID = 1L;

    /** Non parameterized constructor. */
    public ResourceNotFound() {
        super();
    }

    /** parameterized constructor.
     * 
     * @param errorMessage
     *            type of string which is taking the error message */
    public ResourceNotFound(String errorMessage) {
        super(errorMessage);
    }
}
