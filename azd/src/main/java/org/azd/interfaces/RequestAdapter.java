package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.serializer.SerializableEntity;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

public interface RequestAdapter {
    <T extends SerializableEntity> T send(RequestInformation requestInformation,
                                          Class<T> model) throws AzDException;
    <T extends SerializableEntity> CompletableFuture<T> sendAsync(RequestInformation requestInformation,
                                                                  Class<T> model) throws AzDException;
    CompletableFuture<String> sendStringAsync(RequestInformation requestInformation) throws AzDException;
    CompletableFuture<InputStream> sendStreamAsync(RequestInformation requestInformation) throws AzDException;

    CompletableFuture<Void> sendPrimitiveAsync(RequestInformation requestInformation) throws AzDException;
    String sendString(RequestInformation requestInformation) throws AzDException;
    InputStream sendStream(RequestInformation requestInformation) throws AzDException;

    Void sendPrimitive(RequestInformation requestInformation) throws AzDException;
}
