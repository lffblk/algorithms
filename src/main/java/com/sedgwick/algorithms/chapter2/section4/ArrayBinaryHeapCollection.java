package com.sedgwick.algorithms.chapter2.section4;

import com.sedgwick.algorithms.chapter1.ResizingArrayCollection;
import org.apache.commons.collections4.iterators.ArrayIterator;

import java.util.Iterator;

public class ArrayBinaryHeapCollection<Item extends Comparable<Item>> extends ResizingArrayCollection<Item> {

    @SuppressWarnings("unchecked")
    protected ArrayBinaryHeapCollection(int capacity) {
        super(capacity + 1);
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    protected boolean less(int i, int j) {
        return elements[i].compareTo(elements[j]) < 0;
    }

    protected void exchange(int i, int j) {
        Item temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    protected void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    protected void sink(int k) {
        while (2 * k <= currentSize) {
            int j = 2 * k;
            if (j < currentSize && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void resize(int newSize) {
        Item[] temp = (Item[]) new Comparable[newSize];
        System.arraycopy(elements, 0, temp, 0, currentSize + 1);
        elements = temp;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator<Item>(elements);
    }
}
