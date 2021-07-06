package org.azd.validators;

import org.azd.exceptions.ConnectionException;

/**
 * Validates if the default parameters are passed or not
 * @author Harish Karthic
 */
public class AzDDefaultParametersValidator {

    /**
     * Validates if the default parameters are passed or not
     * @throws ConnectionException user should declare the default parameters
     */
    public static void validateDefaultParameters() throws ConnectionException {
        if(System.getProperty("AZD_ORG") == null || System.getProperty("AZD_TOKEN") == null) {
            throw new ConnectionException();
        }
    }
}
