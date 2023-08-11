package org.azd.cache;

public class CacheEntry<V> {
    public CacheEntry(V value, long ttlMillis) {
        this.value = value;
        this.expirationTimeMillis = System.currentTimeMillis() + ttlMillis;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expirationTimeMillis;
    }

    public V getValue() {
        return value;
    }

    private final V value;
    private final long expirationTimeMillis;
}
