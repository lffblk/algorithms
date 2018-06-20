package com.sedgwick.algorithms.chapter2.section4;

import com.sedgwick.algorithms.chapter2.MinPriorityQueue;

public class ArrayBinaryHeapMinPriorityQueue <Item extends Comparable<Item>> extends AbstractBinaryHeapPriorityQueue<Item>
        implements MinPriorityQueue<Item> {

    public ArrayBinaryHeapMinPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    public Item min() {
        return extremumElement();
    }

    @Override
    public Item deleteMin() {
        return deleteExtremumElement();
    }

    @Override
    protected boolean less(int i, int j) {
        return elements[i].compareTo(elements[j]) > 0;
    }
}
