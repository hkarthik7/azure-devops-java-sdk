package org.azd.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * Throws the exception from REST API
 * @author Harish Karthic
 */
@SuppressWarnings("serial")
public class AzDException extends Exception {

    public AzDException() {
        super("Validate the arguments passed for the parameters;");
    }

    public AzDException(String message) {
        super("An Error Occurred: " + message);
    }
}
