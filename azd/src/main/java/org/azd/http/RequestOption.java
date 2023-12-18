package org.azd.http;

import java.net.http.HttpClient;
import java.time.Duration;

public class RequestOption {
    public HttpClient.Redirect getRedirectPolicy() {
        return REDIRECT_POLICY;
    }

    public void setRedirectPolicy(HttpClient.Redirect REDIRECT_POLICY) {
        this.REDIRECT_POLICY = REDIRECT_POLICY;
    }

    public HttpClient.Version getVersion() {
        return VERSION;
    }

    public void setVersion(HttpClient.Version version) {
        this.VERSION = version;
    }

    public Duration getConnectionTimeOut() {
        return CONNECTION_TIME_OUT;
    }

    public void setConnectionTimeOut(long seconds) {
        this.CONNECTION_TIME_OUT = Duration.ofSeconds(seconds);
    }

    public static RequestOption getInstance() {
        return new RequestOption();
    }

    private Duration CONNECTION_TIME_OUT = Duration.ofSeconds(10);
    private HttpClient.Version VERSION = HttpClient.Version.HTTP_2;
    private HttpClient.Redirect REDIRECT_POLICY = HttpClient.Redirect.NORMAL;
}
