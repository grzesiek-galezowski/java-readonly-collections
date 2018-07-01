package com.github.grzesiek_galezowski.collections.readonly.interfaces;

public interface ReadOnlyDeque<T> extends ReadOnlyQueue<T> {
    T getFirst();

    T getLast();

    T peekFirst();

    T peekLast();

    ReadOnlyCollectionIterator<T> descendingIterator();

}
