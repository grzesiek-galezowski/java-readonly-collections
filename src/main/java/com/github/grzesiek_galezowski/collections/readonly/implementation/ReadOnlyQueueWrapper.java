package com.github.grzesiek_galezowski.collections.readonly.implementation;

import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyQueue;

import java.io.Serializable;
import java.util.Queue;

public class ReadOnlyQueueWrapper<T>
    extends ReadOnlyCollectionWrapper<T>
    implements ReadOnlyQueue<T>, Serializable {

    private final Queue<T> original;

    public ReadOnlyQueueWrapper(final Queue<T> original) {
        super(original);
        this.original = original;
    }

    @Override
    public T element() {
        return original.element();
    }

    @Override
    public T peek() {
        return original.peek();
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

        ReadOnlyQueueWrapper<?> that = (ReadOnlyQueueWrapper<?>) o;

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
