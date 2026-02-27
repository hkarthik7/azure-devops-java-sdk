package org.azd.abstractions.pipelines;

import org.azd.abstractions.ResponseHandler;
import org.azd.abstractions.handlers.ResponseContext;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public final class ResponsePipeline {
    private final ResponseHandler handler;

    public ResponsePipeline(ResponseHandler handler) {
        Objects.requireNonNull(handler, "Response pipeline should have at least one handler.");
        this.handler = handler;
    }

    public <T> CompletableFuture<T> processAsync(ResponseContext context) {
        return handler.handleAsync(context)
                .thenApply(v -> (T) context.body());
    }
}
