package org.azd.abstractions;

import org.azd.abstractions.handlers.RetryHandler;

/**
 * Singleton class that configures Api request options.
 */
public class ClientConfiguration {
    private final static ClientConfiguration instance = new ClientConfiguration();
    private static RequestOption reqOption;
    private static RetryHandler retry;

    private ClientConfiguration() {
    }

    /**
     * Get the instance to configure.
     * @return Instance of ClientConfiguration.
     */
    public static ClientConfiguration getInstance() {
        return instance;
    }

    /**
     * Get the request option object.
     * @return RequestOption.
     */
    public RequestOption getRequestOption() {
        return reqOption;
    }

    /**
     * Get the retry handler object.
     * @return RetryHandler.
     */
    public RetryHandler getRetryHandler() {
        return retry;
    }

    /**
     * Configures the request option.
     * @param requestOption Request option object to configure.
     */
    public void configureRequestOption(RequestOption requestOption) {
        reqOption = requestOption;
    }

    /**
     * Configures the retry handler options.
     * @param retryHandler Retry handler object to configure.
     */
    public void configureRetryHandler(RetryHandler retryHandler) {
        retry = retryHandler;
    }
}
