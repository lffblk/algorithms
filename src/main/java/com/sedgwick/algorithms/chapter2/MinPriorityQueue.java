package com.sedgwick.algorithms.chapter2;

import com.sedgwick.algorithms.chapter1.Collection;

public interface MinPriorityQueue<Key extends Comparable<Key>> extends Collection<Key> {

    void insert(Key key);

    Key min();

    Key deleteMin();

}
