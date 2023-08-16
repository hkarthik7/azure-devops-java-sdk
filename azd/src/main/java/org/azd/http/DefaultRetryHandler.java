package org.azd.http;

import org.azd.exceptions.AzDException;
import org.azd.interfaces.RequestAdapter;
import org.azd.interfaces.RetryHandler;
import org.azd.utils.InstanceFactory;

public class DefaultRetryHandler implements RetryHandler {
    @Override
    public AzDResponse retry() {
        var executionCount = 1;
        while (executionCount < DEFAULT_MAX_RETRIES) {
            if (response.retryAfterInterval().isPresent()) {
                try {
                    var delay = response.retryAfterInterval().getAsLong() * RETRY_IN_MILLISECONDS;
                    Thread.sleep(delay);
                    requestAdapter.sendStringAsync(response.getRequestInformation());
                    response = AzDResponseHandler.getResponse();
                    executionCount++;
                } catch (InterruptedException | AzDException e) {
                    throw new RuntimeException(e);
                }
            } else break;
        }
        return response;
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

    public DefaultRetryHandler() {
        this(AzDResponseHandler.getResponse(), null);
    }

    public DefaultRetryHandler(AzDResponse response, RequestAdapter requestAdapter) {
        this.response = response;
        this.requestAdapter = requestAdapter == null ? InstanceFactory.createDefaultRequestAdapter() : requestAdapter;
    }

    private int DEFAULT_MAX_RETRIES = 3;
    private long RETRY_IN_MILLISECONDS = 1000;
    private AzDResponse response;
    private final RequestAdapter requestAdapter;
}
