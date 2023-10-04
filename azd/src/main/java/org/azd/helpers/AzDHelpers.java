package org.azd.helpers;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class AzDHelpers extends URLHelper {
    public static String toString(int[] values) {
        if (values == null) return null;
        return Arrays.stream(values).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    public static String toString(String[] values) {
        if (values == null) return null;
        return String.join(",", values);
    }
}
