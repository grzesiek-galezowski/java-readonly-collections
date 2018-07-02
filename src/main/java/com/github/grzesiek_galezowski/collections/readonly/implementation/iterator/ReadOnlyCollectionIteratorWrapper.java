package com.github.grzesiek_galezowski.collections.implementation.iterator;

import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyCollectionIterator;

import java.util.Iterator;
import java.util.function.Consumer;

public class ReadOnlyCollectionIteratorWrapper<T> implements ReadOnlyCollectionIterator<T> {
    private final Iterator<T> iterator;

    public ReadOnlyCollectionIteratorWrapper(final Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        return iterator.next();
    }

    @Override
    public void forEachRemaining(final Consumer<? super T> action) {
        iterator.forEachRemaining(action);
    }
}
