package org.azd.exceptions;

/**
 * This helps to validate if the user has set the default parameters before calling any
 * other functions in this library.
 * @author Harish Karthic
 * */
@SuppressWarnings("serial")
public class DefaultParametersException extends Exception {
    public DefaultParametersException() {
        super("Please instantiate 'AzDDefaultParameters' class with mandatory parameters 'organization', 'project' and 'personal access token' before calling any functions in this library.");
    }

    public DefaultParametersException(String message) {
        super(message);
    }
}
