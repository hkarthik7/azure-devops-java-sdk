package org.azd.interfaces;

import org.azd.http.RequestInformation;

import java.net.http.HttpResponse;

public interface ResponseHandler {
    <T> void setResponse(HttpResponse<T> response, RequestInformation requestInformation);
}
