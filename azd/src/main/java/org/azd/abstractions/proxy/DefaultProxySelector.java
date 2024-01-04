package org.azd.abstractions.proxy;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Objects;

public class DefaultProxySelector extends ProxySelector {
    private final ProxyConfiguration proxyConfig;

    public DefaultProxySelector(ProxyConfiguration proxyConfig) {
        Objects.requireNonNull(proxyConfig, "Proxy configuration cannot be null.");
        this.proxyConfig = proxyConfig;
    }

    @Override
    public List<Proxy> select(URI uri) {
        if (testProxy(proxyConfig.proxyUrl)) {
            var proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyConfig.proxyUrl, proxyConfig.proxyPort));
            return List.of(proxy);
        } else {
            return List.of(Proxy.NO_PROXY);
        }
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        throw new RuntimeException("Connection to " + uri + " failed. Details: " + ioe.getMessage());
    }

    private boolean testProxy(String url) {
        try {
            if (proxyConfig.noProxyHosts == null) return false;
            var serverUrl = new URL(url).getHost();
            return proxyConfig.noProxyHosts.contains(serverUrl);
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while testing proxy: " + ex.getMessage());
        }
    }
}
