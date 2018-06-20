package com.sedgwick.algorithms.chapter2.section4;

import com.sedgwick.algorithms.chapter2.AbstractSort;

public class HeapSort <Item extends Comparable<Item>> extends AbstractSort<Item> {

    @Override
    public void sort(Item[] array) {
        int n = array.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(array, i, n);
        }
        while (n > 1) {
            exchange(array, 1, n--);
            sink(array, 1, n);
        }
    }

    private void sink(Item[] array, int k, int currentSize) {
        while (2 * k <= currentSize) {
            int j = 2 * k;
            if (j < currentSize && less(j, j + 1, array)) {
                j++;
            }
            if (!less(k, j, array)) {
                break;
            }
            exchange(array, k, j);
            k = j;
        }
    }

    private boolean less(int i, int j, Item[] array) {
        return array[i - 1].compareTo(array[j - 1]) < 0;
    }

    protected void exchange(Item[] array, int i, int j) {
        Item temp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = temp;
    }
}
