package org.azd.http;

import org.azd.interfaces.ResponseHandler;

import java.net.http.HttpResponse;

public class AzDResponseHandler implements ResponseHandler {
    @Override
    public <T> void setResponse(HttpResponse<T> response, RequestInformation requestInformation) {
        AzDResponseHandler.response = new AzDResponse(response.statusCode(), response.headers(),
                response.body(), response.request().uri().toString(), requestInformation);
    }

    public static AzDResponse getResponse() {
        return response;
    }

    private static AzDResponse response;
}
