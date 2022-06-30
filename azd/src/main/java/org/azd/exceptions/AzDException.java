package org.azd.exceptions;

/***
 * Throws the exception from REST API
 */
@SuppressWarnings("serial")
public class AzDException extends Exception {

    public AzDException() {
        super("Cannot validate the arguments passed for the parameters; Please pass the correct values and try again.");
    }

    public AzDException(Throwable cause) {
        super(cause);
    }

    public AzDException(String message) {
        super("An Error Occurred: " + message);
    }

    public AzDException(String exceptionType, String message) {
        super(exceptionType + ": " + message);
    }
}
