package org.azd.abstractions;

import java.net.Authenticator;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.time.Duration;

/**
 * Configuration class to configure the Api request before sending.
 */
public class RequestOption {
    private Duration connectionTimeOut = Duration.ofSeconds(10);
    private HttpClient.Version version = HttpClient.Version.HTTP_2;
    private HttpClient.Redirect redirectPolicy = HttpClient.Redirect.NORMAL;
    private ProxySelector proxySelector;
    private Authenticator authenticator;

    /**
     * Get a new instance.
     * @return RequestObject instance.
     */
    public static RequestOption getInstance() {
        return new RequestOption();
    }

    /**
     * Get the Http redirect policy.
     * @return Default redirect policy.
     */
    public HttpClient.Redirect getRedirectPolicy() {
        return redirectPolicy;
    }

    /**
     * Sets the redirect policy.
     * @param redirectPolicy Redirect policy to set.
     */
    public void setRedirectPolicy(HttpClient.Redirect redirectPolicy) {
        this.redirectPolicy = redirectPolicy;
    }

    /**
     * Get the Http version.
     * @return Default http version which is Http2.0.
     */
    public HttpClient.Version getVersion() {
        return version;
    }

    /**
     * Sets the Http version.
     * @param version Http version to set.
     */
    public void setVersion(HttpClient.Version version) {
        this.version = version;
    }

    /**
     * Request timeout duration.
     * @return Default timeout value. Set to 10 seconds.
     */
    public Duration getConnectionTimeOut() {
        return connectionTimeOut;
    }

    /**
     * Sets the timeout duration.
     * @param seconds Seconds to set as timeout duration.
     */
    public void setConnectionTimeOut(long seconds) {
        this.connectionTimeOut = Duration.ofSeconds(seconds);
    }

    /**
     * Get the proxy selector object.
     * @return ProxySelector {@link ProxySelector}.
     */
    public ProxySelector getProxySelector() {
        return proxySelector;
    }

    /**
     * Sets the proxy selector object.
     * @param proxySelector Proxy selector object to set.
     */
    public void setProxySelector(ProxySelector proxySelector) {
        this.proxySelector = proxySelector;
    }

    /**
     * Get the proxy authentication.
     * @return Authenticator {@link Authenticator}.
     */
    public Authenticator getAuthenticator() {
        return authenticator;
    }

    /**
     * Sets the proxy authenticator.
     * @param authenticator Proxy authenticator to set.
     */
    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }
}
