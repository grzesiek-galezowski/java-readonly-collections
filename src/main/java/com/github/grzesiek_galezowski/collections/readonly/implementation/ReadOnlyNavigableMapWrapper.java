package com.github.grzesiek_galezowski.collections.readonly.implementation;

import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyNavigableMap;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyNavigableSet;

import java.io.Serializable;
import java.util.Map;
import java.util.NavigableMap;

public class ReadOnlyNavigableMapWrapper<K, V>
    extends ReadOnlySortedMapWrapper<K, V>
    implements ReadOnlyNavigableMap<K, V>, Serializable, Cloneable {

    private NavigableMap<K, V> original;

    public ReadOnlyNavigableMapWrapper(final NavigableMap<K, V> original) {
        super(original);
        this.original = original;
    }

    @Override
    public Map.Entry<K, V> lowerEntry(final K key) {
        return original.lowerEntry(key);
    }

    @Override
    public K lowerKey(final K key) {
        return original.lowerKey(key);
    }

    @Override
    public Map.Entry<K, V> floorEntry(final K key) {
        return original.floorEntry(key);
    }

    @Override
    public K floorKey(final K key) {
        return original.floorKey(key);
    }

    @Override
    public Map.Entry<K, V> ceilingEntry(final K key) {

        return original.ceilingEntry(key);
    }

    @Override
    public K ceilingKey(final K key) {
        return original.ceilingKey(key);
    }

    @Override
    public Map.Entry<K, V> higherEntry(final K key) {
        return original.higherEntry(key);
    }

    @Override
    public K higherKey(final K key) {
        return original.higherKey(key);
    }

    @Override
    public Map.Entry<K, V> firstEntry() {
        return original.firstEntry();
    }

    @Override
    public Map.Entry<K, V> lastEntry() {
        return original.lastEntry();
    }

    @Override
    public ReadOnlyNavigableMap<K, V> descendingMap() {
        return new ReadOnlyNavigableMapWrapper<>(original.descendingMap());
    }

    @Override
    public ReadOnlyNavigableSet<K> navigableKeySet() {
        return new ReadOnlyNavigableSetWrapper<>(original.navigableKeySet());
    }

    @Override
    public ReadOnlyNavigableSet<K> descendingKeySet() {
        return new ReadOnlyNavigableSetWrapper<>(original.descendingKeySet());
    }

    @Override
    public ReadOnlyNavigableMap<K, V> subMap(final K fromKey, final boolean fromInclusive, final K toKey, final boolean toInclusive) {
        return new ReadOnlyNavigableMapWrapper<>(original.subMap(fromKey, fromInclusive, toKey, toInclusive));
    }

    @Override
    public ReadOnlyNavigableMap<K, V> headMap(final K toKey, final boolean inclusive) {
        return new ReadOnlyNavigableMapWrapper<>(original.headMap(toKey, inclusive));
    }

    @Override
    public ReadOnlyNavigableMap<K, V> tailMap(final K fromKey, final boolean inclusive) {
        return new ReadOnlyNavigableMapWrapper<>(original.tailMap(fromKey, inclusive));
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

        ReadOnlyNavigableMapWrapper<?, ?> that = (ReadOnlyNavigableMapWrapper<?, ?>) o;

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
