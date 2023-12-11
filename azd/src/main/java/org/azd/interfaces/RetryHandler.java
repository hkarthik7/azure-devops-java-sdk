package org.azd.interfaces;

import org.azd.http.ApiResponse;

public interface RetryHandler {
    ApiResponse retry();
}
