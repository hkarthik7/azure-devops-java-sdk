package org.azd.abstractions;

import org.azd.abstractions.handlers.RetryHandler;

public class ClientConfiguration {
    private final static ClientConfiguration instance = new ClientConfiguration();
    private static RequestOption reqOption;
    private static RetryHandler retry;

    private ClientConfiguration() {
    }

    public static ClientConfiguration getInstance() {
        return instance;
    }

    public RequestOption getRequestOption() {
        return reqOption;
    }

    public RetryHandler getRetryHandler() {
        return retry;
    }

    public void configureRequestOption(RequestOption requestOption) {
        reqOption = requestOption;
    }

    public void configureRetryHandler(RetryHandler retryHandler) {
        retry = retryHandler;
    }
}
