package com.github.grzesiek_galezowski.collections.readonly.implementation;

import com.github.grzesiek_galezowski.collections.implementation.iterator.ReadOnlyCollectionIteratorWrapper;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyCollectionIterator;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyNavigableSet;

import java.io.Serializable;
import java.util.NavigableSet;

public class ReadOnlyNavigableSetWrapper<E>
    extends ReadOnlySortedSetWrapper<E>
    implements ReadOnlyNavigableSet<E>, Serializable {

    private final NavigableSet<E> original;

    public ReadOnlyNavigableSetWrapper(final NavigableSet<E> original) {
        super(original);
        this.original = original;
    }

    @Override
    public E lower(final E var1) {
        return original.lower(var1);
    }

    @Override
    public E floor(final E var1) {
        return original.floor(var1);
    }

    @Override
    public E ceiling(final E var1) {
        return original.ceiling(var1);
    }

    @Override
    public E higher(final E var1) {
        return original.higher(var1);
    }

    @Override
    public ReadOnlyNavigableSet<E> descendingSet() {
        return new ReadOnlyNavigableSetWrapper<>(original.descendingSet());
    }

    @Override
    public ReadOnlyCollectionIterator<E> descendingIterator() {
        return new ReadOnlyCollectionIteratorWrapper<>(original.descendingIterator());
    }

    @Override
    public ReadOnlyNavigableSet<E> subSet(final E var1, final boolean var2, final E var3, final boolean var4) {
        return new ReadOnlyNavigableSetWrapper<>(original.subSet(var1, var2, var3, var4));
    }

    @Override
    public ReadOnlyNavigableSet<E> headSet(final E var1, final boolean var2) {
        return new ReadOnlyNavigableSetWrapper<>(original.headSet(var1, var2));
    }

    @Override
    public ReadOnlyNavigableSet<E> tailSet(final E var1, final boolean var2) {
        return new ReadOnlyNavigableSetWrapper<>(original.tailSet(var1, var2));
    }

    @Override
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

        ReadOnlyNavigableSetWrapper<?> that = (ReadOnlyNavigableSetWrapper<?>) o;

        return original != null ? original.equals(that.original) : that.original == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (original != null ? original.hashCode() : 0);
        return result;
    }
}
