package org.azd.utils;

import org.azd.common.Constants;
import org.azd.helpers.URLHelper;

public class PathBuilder {
    private final StringBuilder pathBuilder;

    private PathBuilder() {
        this.pathBuilder = new StringBuilder();
    }
    public static PathBuilder from(String path) {
        var builder = new PathBuilder();
        if (path != null && !path.isEmpty())
            builder.pathBuilder.append(path);
        return builder;
    }

    public PathBuilder append(String path) {
        if (path == null || path.isEmpty())
            return this;

        if (pathBuilder.length() > 0 && pathBuilder.charAt(pathBuilder.length() - 1) != '/')
            pathBuilder.append(Constants.PATH_SEPARATOR);

        pathBuilder.append(URLHelper.encodeSpace(path));

        return this;
    }

    public String build() {
        return pathBuilder.toString();
    }

}
