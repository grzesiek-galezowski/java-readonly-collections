package com.github.grzesiek_galezowski.collections.readonly.implementation;

import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyCollection;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyMap;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlySet;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;

public class ReadOnlyMapWrapper<K,V> implements ReadOnlyMap<K, V>, Serializable {

    private final Map<K,V> original;

    public ReadOnlyMapWrapper(final Map<K, V> original) {
        this.original = original;
    }

    @Override
    public int size() {
        return original.size();
    }

    @Override
    public boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public boolean containsKey(final Object key) {
        return original.containsKey(key);
    }

    @Override
    public boolean containsValue(final Object value) {
        return original.containsValue(value);
    }

    @Override
    public V get(final Object key) {
        return original.get(key);
    }

    @Override
    public ReadOnlySet<K> keySet() {
        return new ReadOnlySetWrapper<>(original.keySet());
    }

    @Override
    public ReadOnlyCollection<V> values() {
        return new ReadOnlyCollectionWrapper<>(original.values());
    }

    @Override
    public ReadOnlySet<Map.Entry<K, V>> entrySet() {
        return new ReadOnlySetWrapper<>(original.entrySet());
    }

    @Override
    public V getOrDefault(final Object key, final V defaultValue) {
        return original.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(final BiConsumer<? super K, ? super V> action) {
        original.forEach(action);
    }

    @Override
    @SuppressWarnings("checkstyle:all")
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReadOnlyMapWrapper<?, ?> that = (ReadOnlyMapWrapper<?, ?>) o;

        return original != null ? original.equals(that.original) : that.original == null;
    }

    @Override
    @SuppressWarnings("checkstyle:all")
    public int hashCode() {
        return original != null ? original.hashCode() : 0;
    }
}
