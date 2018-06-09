package com.sedgwick.algorithms.chapter1.section3.collections.bag;

import com.sedgwick.algorithms.chapter1.section3.collections.Collection;

public interface Bag<Item> extends Collection<Item> {

    void add(Item item);
}
