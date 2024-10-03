package org.azd.utils;

import java.util.concurrent.CompletableFuture;

@Deprecated(since = "v6.0")
public abstract class AzDAsyncApi<T> {
    public AzDAsyncApi() {
    }

    public <T> CompletableFuture<T> createAsync(T o) {
        return CompletableFuture.supplyAsync(() -> o);
    }
}
