package org.azd.enums;

/**
 * Types of Exception to be thrown
 */
public enum ApiExceptionTypes {
    /**
     * This exception type will be thrown if a string value couldn't be parsed.
     */
    StringValueParsingException,
    /**
     * This will be thrown if an invalid personal access token is supplies.
     */
    InvalidPersonalAccessTokenException,
    /**
     * This will be thrown when an Api response couldn't be parsed.
     */
    ApiResponseParsingException,
    /**
     * This will be thrown when a json content from file couldn't be parsed.
     */
    FileContentParsingException,

    /**
     * Throw this error type if the user passes invalid organization name.
     */
    InvalidOrganizationNameException,
    /**
     * This type will be thrown if the given argument is invalid.
     */
    InvalidArgumentException
}
