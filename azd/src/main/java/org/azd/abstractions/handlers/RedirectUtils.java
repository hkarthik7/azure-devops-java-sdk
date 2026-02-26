package org.azd.abstractions.handlers;

import org.azd.abstractions.InstanceFactory;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

public final class RedirectUtils {

    public static boolean isRedirectStatus(int status) {
        return status == 301 || status == 302 || status == 303
                || status == 307 || status == 308;
    }

    public static boolean hasCallback(ResponseContext context) {
        int status = context.statusCode();

        if (!isRedirectStatus(status) && status != 403) {
            return false;
        }

        if (context.response().uri() != null && status == 403) {
            return true;
        }

        if (context.header("Location").isPresent()) {
            return true;
        }

        if (context.contentType().isJson() && context.body() instanceof String) {
            var body = (String) context.body();
            return body.contains("downloadUrl") || body.contains("url");
        }

        return false;
    }

    public static Optional<URI> extractCallback(ResponseContext context) {

        try {
            var location = context.header("Location");
            if (location.isPresent()) {
                return Optional.of(URI.create(location.get()));
            }

            if (context.response() != null && context.response().uri() != null) {
                return Optional.of(context.response().uri());
            }

            if (context.contentType().isJson() && context.body() instanceof String) {
                var body = (String) context.body();
                final var serializer = InstanceFactory.createSerializerContext();
                var map = serializer.deserialize(body, Map.class);

                if (map.containsKey("downloadUrl")) {
                    return Optional.of(URI.create(map.get("downloadUrl").toString()));
                }

                if (map.containsKey("url")) {
                    return Optional.of(URI.create(map.get("url").toString()));
                }
            }

            return Optional.empty();

        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
