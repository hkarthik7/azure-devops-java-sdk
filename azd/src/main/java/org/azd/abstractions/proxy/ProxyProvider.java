package org.azd.abstractions.proxy;

import org.azd.abstractions.ClientConfiguration;
import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.RequestOption;
import org.azd.abstractions.serializer.SerializerContext;

import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.ProxySelector;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProxyProvider {
    private static final SerializerContext serializer = InstanceFactory.createSerializerContext();
    public static void configure(String url) {
        ProxySelector proxy = null;
        Authenticator authenticator = null;

        if (!isNoProxyHost(Objects.requireNonNull(url))) {
            if (System.getenv("_vsts_task_lib_proxy") != null) {
                try {
                    var proxyFromEnv = new ProxyConfiguration();
                    proxyFromEnv.proxyUrl = System.getenv("_vsts_task_lib_proxy_url");
                    proxyFromEnv.proxyUsername = System.getenv("_vsts_task_lib_proxy_username");
                    proxyFromEnv.proxyPassword = SecretProvider.readTaskLibSecrets(System.getenv("_vsts_task_lib_proxy_password"));
                    proxyFromEnv.noProxyHosts = Collections.singletonList(
                            String.valueOf(serializer.serialize(System.getenv("_vsts_task_lib_proxy_bypass") != null ?
                                    System.getenv("_vsts_task_lib_proxy_bypass") : "[]")));
                    proxy = new DefaultProxySelector(proxyFromEnv);
                    authenticator = new DefaultProxyAuthenticator(proxyFromEnv);
                } catch (Exception e) {
                    throw new RuntimeException("An error occurred while trying to set the proxy: " + e.getMessage());
                }
            }
        }

        setRequestOption(proxy, authenticator);
    }

    public static void configure(ProxyConfiguration proxyConfiguration) {
        ProxySelector proxy = new DefaultProxySelector(proxyConfiguration);;
        Authenticator authenticator = null;

        if (proxyConfiguration.proxyUsername != null && proxyConfiguration.proxyPassword != null)
            authenticator = new DefaultProxyAuthenticator(proxyConfiguration);

        setRequestOption(proxy, authenticator);
    }

    private static boolean isNoProxyHost(String url) {
        var noProxy = "no_proxy";

        if (System.getenv(noProxy) == null) return false;

        var noProxyDomains = Arrays.stream((System.getenv(noProxy) != null ? System.getenv(noProxy) : "")
                        .split(","))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        var serverUrl = getHostFromUrl(url);
        if (serverUrl == null) return false;
        serverUrl = serverUrl.toLowerCase();
        return noProxyDomains.contains(serverUrl);
    }

    private static String getHostFromUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            return url.getHost();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private static void setRequestOption(ProxySelector proxy, Authenticator authenticator) {
        var reqOpt = RequestOption.getInstance();
        reqOpt.setProxySelector(proxy);
        reqOpt.setAuthenticator(authenticator);
        ClientConfiguration.getInstance().configureRequestOption(reqOpt);
    }
}
