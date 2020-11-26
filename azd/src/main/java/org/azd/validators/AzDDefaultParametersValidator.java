package org.azd.validators;

import org.azd.exceptions.DefaultParametersException;

import java.util.Map;

/**
 * Validates if the default parameters are passed or not
 * @author Harish Karthic
 */
public class AzDDefaultParametersValidator {

    private static final ProcessBuilder p = new ProcessBuilder();
    private static final Map<String, String> env = p.environment();

    /**
     * Validates if the default parameters are passed or not
     * @throws DefaultParametersException user should declare the default parameters
     */
    public static void ValidateDefaultParameters() throws DefaultParametersException {
        if(env.get("AZD_ORG") == null || env.get("AZD_TOKEN") == null) {
            throw new DefaultParametersException();
        }
    }
}
