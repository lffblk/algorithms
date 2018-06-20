package com.sedgwick.algorithms.chapter2.section4;

import com.sedgwick.algorithms.chapter2.MaxPriorityQueue;

public abstract class AbstractBinaryHeapPriorityQueue <Item extends Comparable<Item>>
        extends ArrayBinaryHeapCollection<Item> {

    public AbstractBinaryHeapPriorityQueue(int capacity) {
        super(capacity);
    }

    public void insert(Item item) {
        if (currentSize == elements.length) {
            resize(elements.length * 2);
        }
        elements[++currentSize] = item;
        swim(currentSize);
    }

    protected Item extremumElement() {
        return elements[1];
    }

    protected Item deleteExtremumElement() {
        Item extremumElement = extremumElement();
        exchange(1, currentSize--);
        elements[currentSize + 1] = null;
        sink(1);
        if (currentSize > 0 && currentSize == elements.length / 4) {
            resize(elements.length / 2);
        }
        return extremumElement;
    }
}
