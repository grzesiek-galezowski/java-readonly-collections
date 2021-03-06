package com.github.grzesiek_galezowski.collections.readonly.interfaces;

public interface ReadOnlyListIterator<T> extends ReadOnlyCollectionIterator<T> {
    boolean hasPrevious();

    T previous();

    int nextIndex();

    int previousIndex();
}
