package com.github.grzesiek_galezowski.collections.readonly.interfaces;

public interface ReadOnlyQueue<T> extends ReadOnlyCollection<T> {
    T element();

    T peek();
}



