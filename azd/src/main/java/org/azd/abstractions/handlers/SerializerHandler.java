package org.azd.abstractions.handlers;

import org.azd.abstractions.ResponseHandler;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

public final class SerializerHandler extends ResponseHandler {
    private final SerializerContext serializer;

    public SerializerHandler(SerializerContext serializer) {
        this.serializer = serializer;
    }

    @Override
    public CompletableFuture<Void> handleAsync(ResponseContext context) {
        if (context.model() == null) {
            return nextAsync(context);
        }

        try {
            var body = context.body();

            if (context.model().isInstance(body)) {
                return nextAsync(context);
            }

            if (context.contentType().isJson() && body instanceof String) {
                var json = (String) context.body();
                var model = serializer.deserialize(json, context.model());
                context.setBody(model);
                return nextAsync(context);
            }

            if (context.contentType().isJson() && body instanceof InputStream) {
                var stream = (InputStream) context.body();
                var json = StreamHelper.convertToString(stream);
                var model = serializer.deserialize(json, context.model());
                context.setBody(model);
                return nextAsync(context);
            }

            return nextAsync(context);

        } catch (AzDException e) {
            return CompletableFuture.failedFuture(e);
        }
    }
}
