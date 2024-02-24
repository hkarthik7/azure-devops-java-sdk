package org.azd.helpers;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class Utils extends URLHelper {
    public static String toString(int[] values) {
        if (values == null) return null;
        return Arrays.stream(values).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    public static String toString(String[] values) {
        if (values == null) return null;
        return String.join(",", values);
    }

    public static boolean isNullOrEmpty(String value) {
        var isNullOrEmpty = true;
        if (value == null) return isNullOrEmpty;
        if (value.isEmpty() || value.isBlank()) return isNullOrEmpty;
        return false;
    }
}
