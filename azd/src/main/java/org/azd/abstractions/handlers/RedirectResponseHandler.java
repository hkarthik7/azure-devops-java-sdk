package org.azd.abstractions.handlers;

import org.azd.abstractions.ResponseHandler;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

import java.util.concurrent.CompletableFuture;

public final class RedirectResponseHandler extends ResponseHandler {
    @Override
    public CompletableFuture<Void> handleAsync(ResponseContext context) {

        if (!RedirectUtils.hasCallback(context)) {
            return nextAsync(context);
        }

        var uriOpt = RedirectUtils.extractCallback(context);

        if (uriOpt.isEmpty()) {
            return CompletableFuture.failedFuture(
                    new AzDException("Redirect detected but no callback URL found.")
            );
        }

        var uri = uriOpt.get();

        return ClientRequest.builder()
                .URI(uri)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStreamAsync()
                .thenCompose(stream -> {
                    context.setBody(stream);
                    context.setStatusCode(200);
                    return nextAsync(context);
                });
    }
}