package org.azd.utils;

import java.util.concurrent.CompletableFuture;

public abstract class AzDAsyncApi<T> {
    public AzDAsyncApi() {
    }

    public <T> CompletableFuture<T> createAsync(T o) {
        return CompletableFuture.supplyAsync(() -> o);
    }
}
