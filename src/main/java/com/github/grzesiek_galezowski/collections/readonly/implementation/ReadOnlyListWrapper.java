package com.github.grzesiek_galezowski.collections.readonly.implementation;

import com.github.grzesiek_galezowski.collections.implementation.iterator.ReadOnlyListIteratorWrapper;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyList;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyListIterator;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

public class ReadOnlyListWrapper<T>
    extends ReadOnlyCollectionWrapper<T>
    implements ReadOnlyList<T>, Serializable {
    private final List<T> original;

    public ReadOnlyListWrapper(final List<T> list) {
        super(list);
        original = list;
    }

    @Override
    public T get(final int index) {
        return original.get(index);
    }

    @Override
    public int indexOf(final Object o) {
        return original.indexOf(o);
    }

    @Override
    public int lastIndexOf(final Object o) {
        return original.lastIndexOf(o);
    }

    @Override
    public ReadOnlyListIterator<T> listIterator() {
        return new ReadOnlyListIteratorWrapper<>(original.listIterator());
    }

    @Override
    public ReadOnlyListIterator<T> listIterator(final int index) {
        return new ReadOnlyListIteratorWrapper<>(original.listIterator(index));
    }

    @Override
    public List<T> subList(final int fromIndex, final int toIndex) {
        return original.subList(fromIndex, toIndex);
    }

    @Override
    public void forEach(final Consumer<? super T> action) {
        original.forEach(action);
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

        ReadOnlyListWrapper<?> that = (ReadOnlyListWrapper<?>) o;

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
