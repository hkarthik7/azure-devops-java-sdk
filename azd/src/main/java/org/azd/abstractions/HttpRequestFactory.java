package org.azd.abstractions;

import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.Constants;
import org.azd.exceptions.AzDException;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpRequestFactory {
    private final SerializerContext serializer = InstanceFactory.createSerializerContext();
    private final AccessTokenCredential accessTokenCredential;
    private final RequestInformation requestInformation;

    private HttpRequestFactory(AccessTokenCredential accessTokenCredential, RequestInformation requestInformation) {
        this.accessTokenCredential = accessTokenCredential;
        this.requestInformation = requestInformation;
    }

    public static HttpRequest create(AccessTokenCredential accessTokenCredential, RequestInformation requestInformation) {
        var request = new HttpRequestFactory(accessTokenCredential, requestInformation);
        return request.newRequest();
    }

    public HttpRequest newRequest() {
        try {
            var builder = HttpRequest.newBuilder(requestInformation.getRequestUri());

            if (accessTokenCredential != null)
                builder.setHeader(Constants.AUTHORIZATION, accessTokenCredential.getAccessToken());

            requestInformation.requestHeaders.getHeaders().forEach(builder::header);

            var body = HttpRequest.BodyPublishers.ofString(serializer.serialize(requestInformation.requestBody));
            if (requestInformation.inputStream != null)
                body = HttpRequest.BodyPublishers.ofInputStream(() -> requestInformation.inputStream);

            return builder.method(requestInformation.requestMethod.name(), body).build();
        } catch (AzDException ex) {
            throw new RuntimeException(ex);
        }
    }
}
