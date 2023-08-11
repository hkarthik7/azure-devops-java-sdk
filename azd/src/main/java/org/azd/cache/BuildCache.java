package org.azd.cache;

import org.azd.build.types.Build;
import org.azd.interfaces.Cache;

import java.util.concurrent.CompletableFuture;

public class BuildCache {
    public static void update(final Integer buildId, final CompletableFuture<Build> futureBuild) {
        cache.put(buildId, futureBuild, DEFAULT_TTL);
    }

    public static Build getCurrent(Integer buildId) {
        var value = cache.get(buildId);
        if (value != null) return value.join();
        return null;
    }

    public static void setTimeToLive(long ttlMilliSeconds) {
        DEFAULT_TTL = ttlMilliSeconds;
    }

    public static long getTimeToLive() {
        return DEFAULT_TTL;
    }

    private BuildCache() { }
    private static final Cache<Integer, CompletableFuture<Build>> cache = new InternalCache<>();
    private static long DEFAULT_TTL = 60000L;
}
