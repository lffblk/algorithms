package com.sedgwick.algorithms.chapter3;

public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {

    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    int rank(Key key);

    Key select(int k);

    Iterable<Key> keys(Key lo, Key hi);

    default void deleteMin() {
        delete(min());
    }

    default void deleteMax() {
        delete(max());
    }

    default int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        }
        else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        }
        else {
            return rank(hi) - rank(lo);
        }
    }

    default Iterable<Key> keys() {
        return keys(min(), max());
    }

}
