package org.azd.abstractions;

/**
 * Singleton class that configures Api request options.
 */
public class ClientConfiguration {
    private final static ClientConfiguration instance = new ClientConfiguration();
    private static RequestOption reqOption;

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
     * Configures the request option.
     * @param requestOption Request option object to configure.
     */
    public void configureRequestOption(RequestOption requestOption) {
        reqOption = requestOption;
    }
}
