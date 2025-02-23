package org.azd.helpers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Utility class that exposes helper methods.
 */
public final class Utils extends URLHelper {
    /**
     * Converts int array of values to string with ',' separated.
     * @param values int array of values.
     * @return A comma separated string values.
     */
    public static String toString(int... values) {
        if (values == null) return null;
        return Arrays.stream(values).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    /**
     * Converts string array of values to a comma separated string.
     * @param values String array of values.
     * @return A comma separated string values.
     */
    public static String toString(String... values) {
        if (values == null) return null;
        return String.join(",", values);
    }

    /**
     * Converts object array of values to a comma separated string.
     * @param values Object array of values.
     * @return A comma separated string values.
     */
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

    /**
     * Converts integer array to string array.
     * @param values Integer array of values.
     * @return String array of values.
     */
    public static String[] toStringArray(int... values) {
        if (values == null) return null;

        return Arrays.stream(values)
                .parallel()
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
    }

    /**
     * Coverts string array of values to a comma separated encoded string. For instance, if a string contains space
     * it will be encoded as %20.
     * @param values String array of values.
     * @return Comma separated string of values.
     */
    public static String toEncodedString(String... values) {
        if (values == null) return null;
        return Arrays.stream(values)
                .filter(x -> x != null && !x.isBlank())
                .map(URLHelper::encodeSpecialWithSpace)
                .collect(Collectors.joining(","));
    }

    /**
     * Checks if a given string value is null or empty.
     * @param value String value to verify.
     * @return True if given string is null or empty and false if not.
     */
    public static boolean isNullOrEmpty(String value) {
        var isNullOrEmpty = true;
        if (value == null) return isNullOrEmpty;
        if (value.isEmpty() || value.isBlank()) return isNullOrEmpty;
        return false;
    }

    /**
     * Converts the given file contents to base64 encoded string.
     * @param file File object.
     * @return Base64 encoded string.
     */
    public static String toBase64String(File file) {
        Objects.requireNonNull(file);
        try {
            byte[] content = Files.readAllBytes(file.toPath());
            return Base64.getEncoder().encodeToString(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a given input stream to base64 string.
     * @param inputStream Input stream to convert to base64 string.
     * @return Base64 encoded string value.
     */
    public static String toBase64String(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "Input stream cannot be null or empty.");

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            var buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
