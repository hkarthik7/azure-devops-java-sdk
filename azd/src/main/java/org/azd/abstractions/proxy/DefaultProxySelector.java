package org.azd.abstractions.proxy;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of proxy selector.
 */
public class DefaultProxySelector extends ProxySelector {
    private final ProxyConfiguration proxyConfig;

    /**
     * Default.
     * @param proxyConfig Proxy configuration object.
     */
    public DefaultProxySelector(ProxyConfiguration proxyConfig) {
        Objects.requireNonNull(proxyConfig, "Proxy configuration cannot be null.");
        this.proxyConfig = proxyConfig;
    }

    /**
     * Select the URI for connection.
     * @param uri The URI that a connection is required to.
     * @return List of proxy object.
     */
    @Override
    public List<Proxy> select(URI uri) {
        var proxy = Proxy.NO_PROXY;
        if (proxyConfig.proxyUrl != null && proxyConfig.proxyPort > 0)
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyConfig.proxyUrl, proxyConfig.proxyPort));
        return List.of(proxy);
    }

    /**
     * Throw runtime exception in case of connection failure.
     * @param uri The URI that the proxy at sa failed to serve.
     * @param sa The socket address of the proxy/SOCKS server
     * @param ioe The I/O exception thrown when the connect failed.
     */
    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        throw new RuntimeException("Connection to " + uri + " failed. Details: " + ioe.getMessage());
    }
}
