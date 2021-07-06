package org.azd.exceptions;

/**
 * This helps to validate if the user has set the default parameters before using any
 * Apis in this library.
 * */
@SuppressWarnings("serial")
public class ConnectionException extends Exception {
    public ConnectionException() {
        super("Please create a connection object using 'Connection' class with mandatory parameters 'organization', " +
                "'project' and 'personal access token' before using any Apis in this library.");
    }

    public ConnectionException(String message) {
        super(message);
    }
}
