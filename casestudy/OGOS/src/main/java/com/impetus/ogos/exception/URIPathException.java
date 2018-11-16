package com.impetus.ogos.exception;

/** Exception class for wrapping null pointer exception.
 * 
 * @author Pawan Nerkar */
public class URIPathException extends NullPointerException {
    /** Serial Version ID. */
    private static final long serialVersionUID = -8487198053017887004L;

    /** Default Constructor. */
    public URIPathException() {
        super();
    }

    /** Parameterized Constructor.
     * 
     * @param message
     *            exception message to print. */
    public URIPathException(String message) {
        super(message);
    }
}
