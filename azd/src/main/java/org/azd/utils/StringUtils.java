package org.azd.utils;

/**
 * Utility class that initialize an empty string.
 */
public final class StringUtils {

    private StringUtils() {}
    public static final String EMPTY = "";

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
