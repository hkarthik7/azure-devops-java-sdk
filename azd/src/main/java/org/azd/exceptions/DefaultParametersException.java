package org.azd.exceptions;

/**
 * This helps to validate if the user has set the default parameters before using any
 * Apis in this library.
 * */
@SuppressWarnings("serial")
public class DefaultParametersException extends Exception {
    public DefaultParametersException() {
        super("Please create a connection object using 'Connection' class with mandatory parameters 'organization', " +
                "'project' and 'personal access token' before using any Apis in this library.");
    }

    public DefaultParametersException(String message) {
        super(message);
    }
}
