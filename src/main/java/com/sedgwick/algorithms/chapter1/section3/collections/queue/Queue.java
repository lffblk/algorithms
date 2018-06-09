package com.sedgwick.algorithms.chapter1.section3.collections.queue;

import com.sedgwick.algorithms.chapter1.section3.collections.Collection;

public interface Queue<Item> extends Collection<Item> {

    void enqueue(Item item);

    Item dequeue();
}
