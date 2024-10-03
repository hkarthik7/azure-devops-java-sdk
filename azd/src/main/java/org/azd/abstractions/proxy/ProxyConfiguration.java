package org.azd.abstractions.proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProxyConfiguration {
    @JsonProperty("proxyUrl")
    public String proxyUrl;
    @JsonProperty("proxyPort")
    public int proxyPort;
    @JsonProperty("proxyUsername")
    public String proxyUsername;
    @JsonProperty("proxyPassword")
    public String proxyPassword;
    @JsonProperty("noProxyHosts")
    public List<String> noProxyHosts;
}
