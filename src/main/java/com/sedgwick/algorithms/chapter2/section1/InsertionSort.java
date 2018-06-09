package com.sedgwick.algorithms.chapter2.section1;

import com.sedgwick.algorithms.chapter2.AbstractSort;

/*
 * Iterate every element and insert it on its place among already sorted elements.
 */
public class InsertionSort<Item extends Comparable<Item>> extends AbstractSort<Item> {
    @Override
    public void sort(Item[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exchange(array, j, j - 1);
            }
        }
    }
}
