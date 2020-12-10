package org.azd.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * Throws the exception from REST API
 * @author Harish Karthic
 */
@SuppressWarnings("serial")
public class AzDException {

    private static final Logger LOGGER = Logger.getLogger(AzDException.class.getName());

    public static void handleException(Exception e) {
        if (e.getMessage().contains("Unexpected character")) {
            LOGGER.log(Level.WARNING, new StringBuilder().append("Invalid Personal Access Token").append("\n").toString());
        }
        if(e.getMessage().contains("Unrecognized token")) {
            LOGGER.log(Level.WARNING, new StringBuilder().append("Invalid Organisation name").append("\n").toString());
        }
        else {
            LOGGER.log(Level.SEVERE, new StringBuilder().append("An Error Occurred: ").append(e.getMessage()).append("\n").toString());
        }
    }
}
