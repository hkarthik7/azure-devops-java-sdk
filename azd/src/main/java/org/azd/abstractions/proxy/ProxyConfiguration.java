package org.azd.abstractions.proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Proxy configuration specification.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProxyConfiguration {
    /**
     * Proxy url.
     */
    @JsonProperty("proxyUrl")
    public String proxyUrl;
    /**
     * Proxy port number.
     */
    @JsonProperty("proxyPort")
    public int proxyPort;
    /**
     * User name to pass for authentication.
     */
    @JsonProperty("proxyUsername")
    public String proxyUsername;
    /**
     * Password.
     */
    @JsonProperty("proxyPassword")
    public String proxyPassword;
    /**
     * List of no proxy hosts.
     */
    @JsonProperty("noProxyHosts")
    public List<String> noProxyHosts;
}
