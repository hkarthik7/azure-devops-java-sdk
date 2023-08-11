package org.azd.http;

import org.azd.exceptions.AzDException;
import org.azd.interfaces.RequestAdapter;
import org.azd.interfaces.RetryHandler;
import org.azd.utils.AzDDefaultRegisterFactory;

public class DefaultRetryHandler implements RetryHandler {
    public int DEFAULT_MAX_RETRIES = 3;
    public final long RETRY_IN_MILLISECONDS = 1000;

    public DefaultRetryHandler(AzDResponse response, RequestAdapter requestAdapter) {
        this.response = response;
        this.requestAdapter = requestAdapter == null ? AzDDefaultRegisterFactory.createDefaultRequestAdapter() : requestAdapter;
    }

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

    public DefaultRetryHandler() {
        this(AzDResponseHandler.getResponse(), null);
    }
    private AzDResponse response;
    private final RequestAdapter requestAdapter;
}
