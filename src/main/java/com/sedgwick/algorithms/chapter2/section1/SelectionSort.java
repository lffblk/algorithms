package com.sedgwick.algorithms.chapter2.section1;

import com.sedgwick.algorithms.chapter2.AbstractSort;

/*
 * Find least element in array and exchange it with first element.
 * Then find second least element and exchange it with second element.
 * Repeat until array is sorted.
 */
public class SelectionSort<Item extends Comparable<Item>> extends AbstractSort<Item> {

    @Override
    public void sort(Item[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (less(array[j], array[minIndex])) {
                    minIndex = j;
                }
            }
            exchange(array, i, minIndex);
        }
    }
}
