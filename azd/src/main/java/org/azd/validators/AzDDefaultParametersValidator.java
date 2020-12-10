package org.azd.validators;

import org.azd.exceptions.DefaultParametersException;

/**
 * Validates if the default parameters are passed or not
 * @author Harish Karthic
 */
public class AzDDefaultParametersValidator {

    /**
     * Validates if the default parameters are passed or not
     * @throws DefaultParametersException user should declare the default parameters
     */
    public static void validateDefaultParameters() throws DefaultParametersException {
        if(System.getProperty("AZD_ORG") == null || System.getProperty("AZD_TOKEN") == null) {
            throw new DefaultParametersException();
        }
    }
}
