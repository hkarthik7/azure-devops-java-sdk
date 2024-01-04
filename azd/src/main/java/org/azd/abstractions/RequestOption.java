package org.azd.abstractions;

import java.net.Authenticator;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.time.Duration;

public class RequestOption {
    private Duration connectionTimeOut = Duration.ofSeconds(10);
    private HttpClient.Version version = HttpClient.Version.HTTP_2;
    private HttpClient.Redirect redirectPolicy = HttpClient.Redirect.NORMAL;
    private ProxySelector proxySelector;
    private Authenticator authenticator;

    public static RequestOption getInstance() {
        return new RequestOption();
    }

    public HttpClient.Redirect getRedirectPolicy() {
        return redirectPolicy;
    }

    public void setRedirectPolicy(HttpClient.Redirect redirectPolicy) {
        this.redirectPolicy = redirectPolicy;
    }

    public HttpClient.Version getVersion() {
        return version;
    }

    public void setVersion(HttpClient.Version version) {
        this.version = version;
    }

    public Duration getConnectionTimeOut() {
        return connectionTimeOut;
    }

    public void setConnectionTimeOut(long seconds) {
        this.connectionTimeOut = Duration.ofSeconds(seconds);
    }

    public ProxySelector getProxySelector() {
        return proxySelector;
    }

    public void setProxySelector(ProxySelector proxySelector) {
        this.proxySelector = proxySelector;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }
}
