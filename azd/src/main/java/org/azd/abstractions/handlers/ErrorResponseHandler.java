package org.azd.abstractions.handlers;

import org.azd.abstractions.ResponseHandler;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.enums.ApiExceptionTypes;
import org.azd.exceptions.ApiException;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

public final class ErrorResponseHandler extends ResponseHandler {

    private final SerializerContext serializer;

    public ErrorResponseHandler(SerializerContext serializer) {
        this.serializer = serializer;
    }

    @Override
    public CompletableFuture<Void> handleAsync(ResponseContext context) {
        int status = context.statusCode();

        if (status == 203) {
            return CompletableFuture.failedFuture(
                    new AzDException(
                            ApiExceptionTypes.InvalidPersonalAccessTokenException.toString(),
                            "Personal access token passed is invalid; Please pass the valid token and try again."
                    )
            );
        }

        if (status < 400) {
            return nextAsync(context);
        }

        if (status == 401) {
            return CompletableFuture.failedFuture(
                    new AzDException(
                            ApiExceptionTypes.UnAuthorizedException.toString(),
                            "Given token doesn't have access to resource '"
                                    + context.request().getRequestUri() + "'."
                    )
            );
        }

        if (RedirectUtils.hasCallback(context)) {
            return nextAsync(context);
        }

        if (context.contentType().isXml()) {
            try {
                String error;
                if (context.body() instanceof InputStream) {
                    error = StreamHelper.convertToString((InputStream) context.body());
                } else {
                    error = String.valueOf(context.body());
                }

                return CompletableFuture.failedFuture(
                        new AzDException(ApiExceptionTypes.UnknownError.toString(), error)
                );
            } catch (AzDException e) {
                return CompletableFuture.failedFuture(e);
            }
        }

        if (context.contentType().isJson() && context.body() instanceof String) {

            String body = context.body().toString();

            if (body.contains("innerException")) {
                try {
                    var error = serializer.deserialize(body, ApiException.class);

                    return CompletableFuture.failedFuture(
                            new AzDException(error.getTypeKey(), error.getMessage())
                    );

                } catch (AzDException e) {
                    return CompletableFuture.failedFuture(e);
                }
            }

            return CompletableFuture.failedFuture(new AzDException(body));
        }

        if (context.contentType().isJson() && context.body() instanceof InputStream) {

            try {
                var stream = (InputStream) context.body();
                var body = StreamHelper.convertToString(stream);

                if (body.contains("innerException")) {
                    try {
                        var error = serializer.deserialize(body, ApiException.class);

                        return CompletableFuture.failedFuture(
                                new AzDException(error.getTypeKey(), error.getMessage())
                        );

                    } catch (AzDException e) {
                        return CompletableFuture.failedFuture(e);
                    }
                }

                return CompletableFuture.failedFuture(new AzDException(body));
            } catch (AzDException e) {
                return CompletableFuture.failedFuture(e);
            }
        }

        if (context.contentType().isText() || context.contentType().isHtml()) {

            String body = context.body().toString();

            if (body.contains("The resource cannot be found.")) {
                return CompletableFuture.failedFuture(
                        new AzDException(
                                ApiExceptionTypes.InvalidOrganizationNameException.toString(),
                                "Server url '" +
                                        context.request().accessTokenCredential.getOrganizationUrl()
                                        + "' passed is invalid; Please pass the valid url and try again."
                        )
                );
            }

            return CompletableFuture.failedFuture(new AzDException(body));
        }

        return CompletableFuture.failedFuture(
                new AzDException(
                        ApiExceptionTypes.UnknownError.toString(),
                        String.valueOf(context.body())
                )
        );
    }
}
