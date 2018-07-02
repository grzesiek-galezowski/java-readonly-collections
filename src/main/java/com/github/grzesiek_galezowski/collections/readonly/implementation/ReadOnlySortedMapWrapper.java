package com.github.grzesiek_galezowski.collections.readonly.implementation;

import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlySortedMap;

import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedMap;

public class ReadOnlySortedMapWrapper<K, V>
    extends ReadOnlyMapWrapper<K, V>
    implements ReadOnlySortedMap<K, V>, Serializable {

    private SortedMap<K, V> original;

    public ReadOnlySortedMapWrapper(final SortedMap<K, V> original) {
        super(original);
        this.original = original;
    }

    @Override
    public Comparator<? super K> comparator() {
        return original.comparator();
    }

    @Override
    public ReadOnlySortedMap<K, V> subMap(final K fromKey, final K toKey) {
        return new ReadOnlySortedMapWrapper<>(original.subMap(fromKey, toKey));
    }

    @Override
    public ReadOnlySortedMap<K, V> headMap(final K toKey) {
        return new ReadOnlySortedMapWrapper<>(original.headMap(toKey));
    }

    @Override
    public ReadOnlySortedMap<K, V> tailMap(final K fromKey) {
        return new ReadOnlySortedMapWrapper<>(original.tailMap(fromKey));
    }

    @Override
    public K firstKey() {
        return original.firstKey();
    }

    @Override
    public K lastKey() {
        return original.lastKey();
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
        if (!super.equals(o)) {
            return false;
        }

        ReadOnlySortedMapWrapper<?, ?> that = (ReadOnlySortedMapWrapper<?, ?>) o;

        return original != null ? original.equals(that.original) : that.original == null;
    }

    @Override
    @SuppressWarnings("checkstyle:all")
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (original != null ? original.hashCode() : 0);
        return result;
    }
}
