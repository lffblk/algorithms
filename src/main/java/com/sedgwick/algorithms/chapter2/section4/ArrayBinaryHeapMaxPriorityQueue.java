package com.sedgwick.algorithms.chapter2.section4;

import com.sedgwick.algorithms.chapter2.MaxPriorityQueue;

public class ArrayBinaryHeapMaxPriorityQueue<Item extends Comparable<Item>> extends AbstractBinaryHeapPriorityQueue<Item>
        implements MaxPriorityQueue<Item> {

    public ArrayBinaryHeapMaxPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    public Item max() {
        return extremumElement();
    }

    @Override
    public Item deleteMax() {
        return deleteExtremumElement();
    }
}
