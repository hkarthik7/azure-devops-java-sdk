package org.azd.helpers;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/***
 * Url helper class to encode the special characters in the url.
 */
public class URLHelper {
    // Replacing the empty string with URL encoder. Without this I'm getting an exception.
    // URI class follows RFC 3986. Reference - https://docs.jboss.org/resteasy/docs/1.0.1.GA/javadocs/javax/ws/rs/core/UriBuilder.html

    /***
     * Encode the space character in the given string
     * @param s input string value
     * @return the encoded string value
     */
    public static String encodeSpace(String s) {
        if (s.contains(" ")) return s.replace(" ", "%20");
        return s;
    }

    /***
     * Encodes any special character in the given string
     * @param s input string value
     * @return he encoded string value
     */
    public static String encodeSpecialChars(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
    }

    /***
     * Combine the two functionality above: encode and replace space characters after the fact with '%20'
     * @param s input string value
     * @return String encoded string value
     */
    public static String encodeSpecialWithSpace(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8).replace("+", "%20");
    }
}
