package com.sedgwick.algorithms.chapter2.section3;

import com.sedgwick.algorithms.chapter2.AbstractSort;
import com.sedgwick.algorithms.libs.StdRandom;

/*
 * 1. Select element array[j]:
 *    1.1 array[j] is situated on right place
 *    1.2 elements array[low] ... array[j - 1] ara less or equals array[j]
 *    1.3 elements array[j + 1] ... array[high] ara greater or equals array[j]
 * 2. Recursively sort arrays from the left and from the right of array[j]
 *
 * Complexity: log(N)
 */
public class QuickSort<Item extends Comparable<Item>> extends AbstractSort<Item> {

    @Override
    public void sort(Item[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private void sort(Item[] array, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(array, low, high);
        sort(array, low, j - 1);
        sort(array, j + 1, high);
    }

    private int partition(Item[] array, int low, int high) {
        int i = low;
        int j = high + 1;
        Item v = array[low];
        while (true) {
            while (less(array[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            while (less(v, array[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(array, i, j);
        }
        exchange(array, low, j);
        return j;
    }
}
