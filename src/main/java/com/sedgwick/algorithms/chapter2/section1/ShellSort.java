package com.sedgwick.algorithms.chapter2.section1;

import com.sedgwick.algorithms.chapter2.AbstractSort;

/*
 * Improved insertion sort. Exchange not only neighboring elements, but elements with h distance.
 * h = 1, 4, 13, 40, 121, 364, 1093, ...
 */
public class ShellSort<Item extends Comparable<Item>> extends AbstractSort<Item> {

    @Override
    public void sort(Item[] array) {
        int length = array.length;
        int h = 1;
        while (h < length / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    exchange(array, j , j - h);
                }
            }
            h = h / 3;
        }
    }
}
