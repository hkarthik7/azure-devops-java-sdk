package org.azd.interfaces;

import java.net.http.HttpResponse;

public interface ResponseHandler {
    <T> void setResponse(HttpResponse<T> response);
}
