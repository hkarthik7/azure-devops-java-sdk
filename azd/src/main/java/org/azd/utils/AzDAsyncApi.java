package org.azd.utils;

import org.azd.connection.Connection;

import java.util.concurrent.CompletableFuture;

public abstract class AzDAsyncApi<T> {
    private final Connection CONNECTION;

    public AzDAsyncApi(Connection connection) { CONNECTION = connection; }

    public <T> CompletableFuture<T> createAsync(T o) {
        return CompletableFuture.supplyAsync(() -> o, CONNECTION.getExecutorService());
    }
}
