package org.azd.exceptions;

/***
 * Throws the exception from REST API
 * @author Harish Karthic
 */
@SuppressWarnings("serial")
public class AzDException extends IllegalArgumentException {

    public AzDException() {
        super("Validate the arguments passed for the parameters;");
    }

    public AzDException(String message) {
        super("An Error Occurred: " + message);
    }
}
