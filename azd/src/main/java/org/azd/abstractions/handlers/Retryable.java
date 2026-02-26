package org.azd.abstractions.handlers;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public interface Retryable<T> {
    CompletableFuture<HttpResponse<T>> run();
}
