package org.azd.helpers;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class Utils extends URLHelper {
    public static String toString(int... values) {
        if (values == null) return null;
        return Arrays.stream(values).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    public static String toString(String... values) {
        if (values == null) return null;
        return String.join(",", values);
    }

    public static String toString(Object... values) {
        if (values == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i < values.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String toEncodedString(String... values) {
        if (values == null) return null;
        return Arrays.stream(values)
                .filter(x -> x != null && !x.isBlank())
                .map(URLHelper::encodeSpecialWithSpace)
                .collect(Collectors.joining(","));
    }

    public static boolean isNullOrEmpty(String value) {
        var isNullOrEmpty = true;
        if (value == null) return isNullOrEmpty;
        if (value.isEmpty() || value.isBlank()) return isNullOrEmpty;
        return false;
    }
}
