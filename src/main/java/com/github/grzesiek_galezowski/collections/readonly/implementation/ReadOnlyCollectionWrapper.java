package com.github.grzesiek_galezowski.collections.readonly.implementation;

import com.github.grzesiek_galezowski.collections.implementation.iterator.ReadOnlyCollectionIteratorWrapper;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyCollection;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyCollectionIterator;

import java.io.Serializable;
import java.util.Collection;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class ReadOnlyCollectionWrapper<T> implements ReadOnlyCollection<T>, Serializable {
    private final Collection<T> original;

    public ReadOnlyCollectionWrapper(final Collection<T> original) {
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
    public boolean contains(final Object o) {
        return original.contains(o);
    }

    @Override
    public ReadOnlyCollectionIterator<T> iterator() {
        return new ReadOnlyCollectionIteratorWrapper<T>(original.iterator());
    }

    @Override
    public Object[] toArray() {
        return original.toArray();
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        return original.toArray(a);
    }

    @Override
    public <T1> T1[] toArray(final IntFunction<T1[]> intFunction) {
        return original.stream().toArray(intFunction);
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return original.containsAll(c);
    }

    @Override
    public Spliterator<T> spliterator() {
        return original.spliterator();
    }

    @Override
    public Stream<T> stream() {
        return original.stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return original.parallelStream();
    }

    @SuppressWarnings("checkstyle:all")
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReadOnlyCollectionWrapper<?> that = (ReadOnlyCollectionWrapper<?>) o;

        return original != null ? original.equals(that.original) : that.original == null;
    }

    @SuppressWarnings("checkstyle:all")
    @Override
    public int hashCode() {
        return original != null ? original.hashCode() : 0;
    }
}
