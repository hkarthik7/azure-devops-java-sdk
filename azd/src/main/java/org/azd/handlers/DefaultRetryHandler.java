package org.azd.handlers;

import org.azd.interfaces.RetryHandler;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.OptionalLong;

public class DefaultRetryHandler implements RetryHandler {

    public DefaultRetryHandler() {}

    @Override
    public <T> void retry(HttpResponse<T> response) {
        var executionCount = 1;
        while (executionCount < DEFAULT_MAX_RETRIES) {
            if (retryAfterInterval(response.headers()).isPresent()) {
                try {
                    var delay = retryAfterInterval(response.headers()).getAsLong() * RETRY_IN_MILLISECONDS;
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else break;
        }
    }

    public int getDefaultMaxRetry() {
        return this.DEFAULT_MAX_RETRIES;
    }

    public long getRetryInMilliSeconds() {
        return this.RETRY_IN_MILLISECONDS;
    }

    public void setDefaultMaxRetry(int defaultMaxRetry) {
        this.DEFAULT_MAX_RETRIES = defaultMaxRetry;
    }

    public void setRetryInMilliSeconds(long retryInMilliSeconds) {
        this.RETRY_IN_MILLISECONDS = retryInMilliSeconds;
    }

    /**
     * Http Headers of last request. We want to make these accessible everywhere (i.e) something that
     * can be checked after every request, but we don't want to have to modify all the existing API methods
     * to return the data.
     *
     * We need this to be able to check if we are near any API rate limits - as creating 20+ releases in
     * a short time can cause one to go over the limit and even have requests fail.
     * Method to get retryAfterInterval value from response header
     * @return Value in seconds (if it exists in header) of how long we should wait to send next request.
     */
    private OptionalLong retryAfterInterval(HttpHeaders headers) {
        if (headers != null) {
            return headers.firstValueAsLong("Retry-After");
        }
        return OptionalLong.empty();
    }

    private int DEFAULT_MAX_RETRIES = 3;
    private long RETRY_IN_MILLISECONDS = 1000;
}
