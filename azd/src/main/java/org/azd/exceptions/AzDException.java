package org.azd.exceptions;

/***
 * Throws the exception from REST API
 * @author Harish Karthic
 */
@SuppressWarnings("serial")
public class AzDException extends Exception {

    public AzDException() {
        super("Validate the arguments passed for the parameters;");
    }

    public AzDException(Throwable cause) { super(cause); }

    public AzDException(String message) {
        super("An Error Occurred: " + message);
    }

    public AzDException(String exceptionType, String message) {
        super(exceptionType + ": " + message);
    }
}
