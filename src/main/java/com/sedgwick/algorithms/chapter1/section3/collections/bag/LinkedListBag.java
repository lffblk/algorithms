package com.sedgwick.algorithms.chapter1.section3.collections.bag;

import com.sedgwick.algorithms.chapter1.section3.collections.LinkedListCollection;

public class LinkedListBag<Item> extends LinkedListCollection<Item> implements Bag<Item> {

    @Override
    public void add(Item item) {
        pushElement(item);
    }
}
