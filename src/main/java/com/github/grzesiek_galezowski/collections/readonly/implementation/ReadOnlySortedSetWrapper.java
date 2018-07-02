package com.github.grzesiek_galezowski.collections.readonly.implementation;

import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlySortedSet;

import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;

public class ReadOnlySortedSetWrapper<T> extends ReadOnlySetWrapper<T>
    implements ReadOnlySortedSet<T>, Serializable {

    private final SortedSet<T> original;

    public ReadOnlySortedSetWrapper(final SortedSet<T> original) {
        super(original);
        this.original = original;
    }

    @Override
    public Comparator<? super T> comparator() {
        return original.comparator();
    }

    @Override
    public ReadOnlySortedSet<T> subSet(final T var1, final T var2) {
        return new ReadOnlySortedSetWrapper<>(original.subSet(var1, var2));
    }

    @Override
    public ReadOnlySortedSet<T> headSet(final T var1) {
        return new ReadOnlySortedSetWrapper<>(original.headSet(var1));
    }

    @Override
    public ReadOnlySortedSet<T> tailSet(final T var1) {
        return new ReadOnlySortedSetWrapper<>(original.tailSet(var1));
    }

    @Override
    public T first() {
        return original.first();
    }

    @Override
    public T last() {
        return original.last();
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

        ReadOnlySortedSetWrapper<?> that = (ReadOnlySortedSetWrapper<?>) o;

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
