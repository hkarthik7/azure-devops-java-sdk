package org.azd.interfaces;

public interface Cache<K, V> {
    void put(K key, V value, long ttlMillis);
    V get(K key);
    void remove(K key);
    void clear();
}
