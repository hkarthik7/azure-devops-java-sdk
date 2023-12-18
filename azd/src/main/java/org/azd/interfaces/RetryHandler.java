package org.azd.interfaces;

import java.net.http.HttpResponse;

public interface RetryHandler {
    <T> void retry(HttpResponse<T> response);
}
