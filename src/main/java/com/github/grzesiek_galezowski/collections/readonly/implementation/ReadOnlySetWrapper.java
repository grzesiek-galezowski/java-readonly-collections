package com.github.grzesiek_galezowski.collections.readonly.implementation;

import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlySet;

import java.io.Serializable;
import java.util.Set;

public class ReadOnlySetWrapper<T> extends ReadOnlyCollectionWrapper<T>
    implements ReadOnlySet<T>, Serializable {

    public ReadOnlySetWrapper(final Set<T> original) {
        super(original);
    }

}
