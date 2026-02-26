package org.azd.abstractions.handlers;

import java.net.http.HttpResponse;
import java.util.OptionalLong;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Retries the Api call based on Retry-After header value.
 */
public class DefaultRetryHandler implements RetryHandler {
    /**
     * Maximum retries
     */
    private static final int MAX_RETRIES = 6;

    /**
     * Executes the given retryable operation.
     * @param operation Function to retry
     * @return Future of HttpResponse object
     * @param <T> Typed value.
     */
    @Override
    public <T> CompletableFuture<HttpResponse<T>> executeAsync(Retryable<T> operation) {
        return retry(operation, 1);
    }

    /**
     * Retries the given retryable operation.
     * @param operation Function to retry
     * @param attempt number of attempts to retry.
     * @return Future of HttpResponse object
     * @param <T> Typed value.
     */
    private <T> CompletableFuture<HttpResponse<T>> retry(Retryable<T> operation, int attempt) {
        return operation.run().thenCompose(response -> {
            var retryAfter = response.headers().firstValueAsLong("Retry-After");

            if (shouldRetry(response.statusCode(), retryAfter, attempt)) {
                long delayMillis = retryAfter.getAsLong() * 1000;
                return CompletableFuture
                        .runAsync(() -> { },
                                CompletableFuture.delayedExecutor(
                                        delayMillis,
                                        TimeUnit.MILLISECONDS))
                        .thenCompose(v -> retry(operation, attempt + 1));
            }

            return CompletableFuture.completedFuture(response);
        });
    }

    /**
     * Returns true if the status code is 429, 503 or retry after interval is present.
     * @param status Http status code.
     * @param retryAfter Retry after interval in seconds.
     * @param attempt Number of attempts. Maximum is 6.
     * @return boolean.
     */
    private boolean shouldRetry(int status, OptionalLong retryAfter, int attempt) {
        if (attempt >= MAX_RETRIES) {
            return false;
        }
        return (status == 429 || status == 503)
                && retryAfter.isPresent();
    }
}
