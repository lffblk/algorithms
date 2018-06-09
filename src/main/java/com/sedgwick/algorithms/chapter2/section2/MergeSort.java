package com.sedgwick.algorithms.chapter2.section2;

import com.sedgwick.algorithms.chapter2.AbstractSort;

public class MergeSort<Item extends Comparable<Item>> extends AbstractSort<Item> {

    protected Item[] temp;

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Item[] array) {
        temp = (Item[]) new Comparable[array.length];
        sort(array, 0, array.length - 1);
    }

    private void sort(Item[] array, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    protected void merge(Item[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        System.arraycopy(array, low, temp, low, high + 1 - low);

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = temp[j++];
            }
            else if (j > high) {
                array[k] = temp[i++];
            }
            else if (less(temp[j], temp[i])) {
                array[k] = temp[j++];
            }
            else {
                array[k] = temp[i++];
            }
        }
    }
}
