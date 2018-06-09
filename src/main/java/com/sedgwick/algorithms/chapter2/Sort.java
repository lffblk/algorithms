package com.sedgwick.algorithms.chapter2;

public interface Sort<Item> {
    void sort(Item[] array);
    boolean isSorted(Item[] array);
}
