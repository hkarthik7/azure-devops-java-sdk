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
        var proxy = Proxy.NO_PROXY;
        if (proxyConfig.proxyUrl != null && proxyConfig.proxyPort > 0)
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyConfig.proxyUrl, proxyConfig.proxyPort));
        return List.of(proxy);
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        throw new RuntimeException("Connection to " + uri + " failed. Details: " + ioe.getMessage());
    }
}
