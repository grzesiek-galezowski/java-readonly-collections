package com.github.grzesiek_galezowski.collections.readonly.factory;

import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlyCollectionWrapper;
import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlyDequeWrapper;
import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlyListWrapper;
import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlyMapWrapper;
import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlyNavigableMapWrapper;
import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlyNavigableSetWrapper;
import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlyQueueWrapper;
import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlySetWrapper;
import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlySortedMapWrapper;
import com.github.grzesiek_galezowski.collections.readonly.implementation.ReadOnlySortedSetWrapper;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyCollection;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyDeque;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyList;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyMap;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyNavigableMap;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyNavigableSet;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlyQueue;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlySet;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlySortedMap;
import com.github.grzesiek_galezowski.collections.readonly.interfaces.ReadOnlySortedSet;

import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class ReadOnlyCollections {
    public static <T> ReadOnlyCollection<T> readOnly(final Collection<T> collection) {
        return new ReadOnlyCollectionWrapper<>(collection);
    }

    public static <T> ReadOnlyList<T> readOnly(final List<T> list) {
        return new ReadOnlyListWrapper<>(list);
    }

    public static <T> ReadOnlySet<T> readOnly(final Set<T> set) {
        return new ReadOnlySetWrapper<>(set);
    }

    public static <T> ReadOnlyQueue<T> readOnly(final Queue<T> queue) {
        return new ReadOnlyQueueWrapper<>(queue);
    }

    public static <T> ReadOnlyDeque<T> readOnly(final Deque<T> deque) {
        return new ReadOnlyDequeWrapper<>(deque);
    }

    public static <T> ReadOnlyNavigableSet<T> readOnly(final NavigableSet<T> navigableSet) {
        return new ReadOnlyNavigableSetWrapper<>(navigableSet);
    }

    public static <T> ReadOnlySortedSet<T> readOnly(final SortedSet<T> sortedSet) {
        return new ReadOnlySortedSetWrapper<>(sortedSet);
    }

    public static <K,V> ReadOnlyMap<K,V> readOnly(final Map<K, V> map) {
        return new ReadOnlyMapWrapper<>(map);
    }
    public static <K,V> ReadOnlySortedMap<K,V> readOnly(final SortedMap<K, V> sortedMap) {
        return new ReadOnlySortedMapWrapper<>(sortedMap);
    }
    public static <K,V> ReadOnlyNavigableMap<K,V> readOnly(final NavigableMap<K, V> navigableMap) {
        return new ReadOnlyNavigableMapWrapper<>(navigableMap);
    }
}
