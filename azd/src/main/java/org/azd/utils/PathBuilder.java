package org.azd.utils;

import org.azd.common.Constants;
import org.azd.helpers.URLHelper;

/**
 * Helper class to build the path parameter.
 * This comes handy when a lengthy path should be constructed in a concise way.
 */
public class PathBuilder {
    /**
     * Path value tracker.
     */
    private final StringBuilder pathBuilder;

    private PathBuilder() {
        this.pathBuilder = new StringBuilder();
    }

    /**
     * Constructs the builder instance with the passed path value.
     * @param path Path value. e.g., 'devops'.
     * @return PathBuilder instance. {@link PathBuilder}
     */
    public static PathBuilder from(String path) {
        var builder = new PathBuilder();
        if (path != null && !path.isEmpty())
            builder.pathBuilder.append(path);
        return builder;
    }

    /**
     * Appends the additional path value to the path builder instance.
     * @param path Path value. e.g., 'url'. This will append the additional value to the
     *             previous path as 'devops/url'.
     * @return PathBuilder instance. {@link PathBuilder}
     */
    public PathBuilder append(String path) {
        if (path == null || path.isEmpty())
            return this;

        if (pathBuilder.length() > 0 && pathBuilder.charAt(pathBuilder.length() - 1) != '/')
            pathBuilder.append(Constants.PATH_SEPARATOR);

        pathBuilder.append(URLHelper.encodeSpace(path));

        return this;
    }

    /**
     * Constructs the complete path and returns the value as 'devops/url/some/value'.
     * @return Constructed path value.
     */
    public String build() {
        return pathBuilder.toString();
    }

}
