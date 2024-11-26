package org.azd.abstractions.proxy;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Objects;

/**
 * Proxy authentication implementation.
 */
public class DefaultProxyAuthenticator extends Authenticator {
    private final ProxyConfiguration proxyConfig;

    /**
     * Default
     * @param proxyConfig Pass the proxy config.
     */
    public DefaultProxyAuthenticator(ProxyConfiguration proxyConfig) {
        this.proxyConfig = Objects.requireNonNull(proxyConfig, "Proxy configuration cannot be null.");
    }

    /**
     * Get the password authentication.
     * @return Pass authentication object. {@link PasswordAuthentication}.
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(proxyConfig.proxyUsername, proxyConfig.proxyPassword.toCharArray());
    }
}
