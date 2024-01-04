package org.azd.configurations;

import org.azd.abstractions.ClientConfiguration;
import org.azd.abstractions.proxy.DefaultProxyAuthenticator;
import org.azd.abstractions.proxy.DefaultProxySelector;
import org.azd.abstractions.proxy.ProxyConfiguration;

import java.util.Objects;

/**
 * Configuration builder to configure the client settings such as setting default retry and proxy configuration.
 */
public class ConfigurationRequestBuilder {
    /**
     * Configures proxy setting for HttpClient.
     * <p> Example:
     * <pre>{@code
     * ProxyConfiguration proxyConfiguration = new ProxyConfiguration();
     * proxyConfiguration.proxyUrl = "https://127.0.0.1";
     * proxyConfiguration.proxyPort = 8888;
     * proxyConfiguration.proxyUsername = System.getenv("https.proxy_username");
     * proxyConfiguration.proxyPassword = System.getenv("https.proxy_password");
     * proxyConfiguration.noProxyHosts = List.of("hostname");
     * }</pre>
     *
     * @param proxyConfiguration Pass the new proxy configuration object.
     */
    public void proxy(ProxyConfiguration proxyConfiguration) {
        Objects.requireNonNull(proxyConfiguration, "Proxy configuration cannot be null.");
        var reqOption = ClientConfiguration.getInstance().getRequestOption();
        var proxySelector = new DefaultProxySelector(proxyConfiguration);
        if (proxyConfiguration.proxyUsername != null && proxyConfiguration.proxyPassword != null)
            reqOption.setAuthenticator(new DefaultProxyAuthenticator(proxyConfiguration));
        reqOption.setProxySelector(proxySelector);
        ClientConfiguration.getInstance().configureRequestOption(reqOption);
    }

    /**
     * Sets the maximum retries for retrying the request if "Retry-After" header is found in the response headers.
     * Default retries is set to 3 and maximum value can be set to 6.
     *
     * @param maxRetry Maximum retry value.
     */
    public void setMaxRetry(int maxRetry) {
        var retryHandler = ClientConfiguration.getInstance().getRetryHandler();
        retryHandler.setDefaultMaxRetry(maxRetry);
    }
}
