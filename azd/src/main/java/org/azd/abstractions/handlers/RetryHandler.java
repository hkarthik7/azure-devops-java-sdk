package org.azd.abstractions.handlers;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public interface RetryHandler {
    <T> CompletableFuture<HttpResponse<T>> executeAsync(Retryable<T> operation);
}
