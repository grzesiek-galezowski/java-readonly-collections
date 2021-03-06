package com.github.grzesiek_galezowski.collections.readonly.interfaces;

import java.util.function.Consumer;

public interface ReadOnlyCollectionIterator<T> {
    boolean hasNext();

    T next();

    void forEachRemaining(Consumer<? super T> action);
}
