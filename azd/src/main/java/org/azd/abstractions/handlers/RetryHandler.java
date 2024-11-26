package org.azd.abstractions.handlers;

import org.azd.abstractions.ApiResponse;
import org.azd.exceptions.AzDException;

import java.net.http.HttpHeaders;
import java.util.OptionalLong;

/**
 * Retries the Api call based on Retry-After header value.
 */
public class RetryHandler {
    private final int MAX_RETRIES = 6;
    private final long RETRY_IN_MILLISECONDS = 1000;
    private final RequestExecutor executor;
    private int DEFAULT_MAX_RETRIES = 3;

    public RetryHandler(RequestExecutor executor) {
        this.executor = executor;
    }

    /**
     * Retries the Api call for the given Api response object. Determines the request information and
     * retries the request for maximum of 6 times.
     * @param response Api response object {@link ApiResponse}.
     * @return Retries Api response. {@link ApiResponse}.
     * @param <T> Type parameter.
     */
    public <T> ApiResponse retry(ApiResponse response) {
        var executionCount = 1;
        while (executionCount < DEFAULT_MAX_RETRIES) {
            var headers = response.getResponseHeaders();
            if (retryAfterInterval(headers).isPresent()) {
                try {
                    var delay = retryAfterInterval(headers).getAsLong() * RETRY_IN_MILLISECONDS;
                    Thread.sleep(delay);
                    executionCount++;
                    // Call Api
                    response = executor.execute();
                } catch (InterruptedException | AzDException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            } else break;
        }
        return response;
    }

    /**
     * Get the default max retry value.
     * @return Default retry value which is 6.
     */
    public int getDefaultMaxRetry() {
        return this.DEFAULT_MAX_RETRIES;
    }

    /**
     * Sets the default max retry value.
     * @param defaultMaxRetry Default value to set. The value can't be more than 6.
     */
    public void setDefaultMaxRetry(int defaultMaxRetry) {
        if (defaultMaxRetry > MAX_RETRIES || defaultMaxRetry < 0)
            throw new IllegalArgumentException("Max retry value cannot be less than 0 or greater than 6.");
        this.DEFAULT_MAX_RETRIES = defaultMaxRetry;
    }

    /**
     * Http Headers of last request. We want to make these accessible everywhere (i.e) something that
     * can be checked after every request, but we don't want to have to modify all the existing API methods
     * to return the data.
     * <p>
     * We need this to be able to check if we are near any API rate limits - as creating 20+ releases in
     * a short time can cause one to go over the limit and even have requests fail.
     * Method to get retryAfterInterval value from response header
     *
     * @return Value in seconds (if it exists in header) of how long we should wait to send next request.
     */
    private OptionalLong retryAfterInterval(HttpHeaders headers) {
        if (headers != null) {
            return headers.firstValueAsLong("Retry-After");
        }
        return OptionalLong.empty();
    }
}
