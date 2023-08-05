package org.azd.http;

import org.azd.interfaces.ResponseHandler;

import java.net.http.HttpResponse;

public class AzDResponseHandler implements ResponseHandler {
    @Override
    public <T> void setResponse(HttpResponse<T> response) {
        AzDResponseHandler.response = new AzDResponse(response.statusCode(), response.headers(), response.body());
    }

    public static AzDResponse getResponse() {
        return response;
    }

    private static AzDResponse response;
}
