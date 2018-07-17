package com.sedgwick.algorithms.chapter3;

public interface SymbolTable<Key, Value> {

    void put(Key key, Value value);

    Value get(Key key);

    int size();

    Iterable<Key> keys();

    default void delete(Key key) {
        put(key, null);
    }

    default boolean contains(Key key) {
        return get(key) != null;
    }

    default boolean isEmpty() {
        return size() == 0;
    }

}
