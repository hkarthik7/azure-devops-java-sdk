package org.azd.interfaces;

import org.azd.http.AzDResponse;

public interface RetryHandler {
    AzDResponse retry();
}
