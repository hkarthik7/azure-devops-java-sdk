package org.azd.helpers;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLHelper {
    // Replacing the empty string with URL encoder. Without this I'm getting an exception.
    // URI class follows RFC 3986. Reference - https://docs.jboss.org/resteasy/docs/1.0.1.GA/javadocs/javax/ws/rs/core/UriBuilder.html
    public static String encodeSpace(String s) {
        if (s.contains(" ")) return s.replace(" ", "%20");
        return s;
    }

    public static String encodeSpecialChars(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }
}
