package org.azd.abstractions.proxy;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Objects;

public class DefaultProxyAuthenticator extends Authenticator {
    private final ProxyConfiguration proxyConfig;

    public DefaultProxyAuthenticator(ProxyConfiguration proxyConfig) {
        this.proxyConfig = Objects.requireNonNull(proxyConfig, "Proxy configuration cannot be null.");
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(proxyConfig.proxyUsername, proxyConfig.proxyPassword.toCharArray());
    }
}
