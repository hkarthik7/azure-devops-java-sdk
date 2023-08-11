package org.azd.cache;

public class CacheEntry<V> {
    private final V value;
    private final long expirationTimeMillis;

    CacheEntry(V value, long ttlMillis) {
        this.value = value;
        this.expirationTimeMillis = System.currentTimeMillis() + ttlMillis;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expirationTimeMillis;
    }

    V getValue() {
        return value;
    }

}
