package com.sedgwick.algorithms.chapter2.section2;

public class BottomUpMergeSort<Item extends Comparable<Item>> extends MergeSort<Item> {

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Item[] array) {
        int n = array.length;
        temp = (Item[]) new Comparable[n];
        for (int sz = 1; sz < n; sz *= 2) {
            for (int low = 0; low < n - sz; low += sz * 2) {
                merge(array, low, low + sz - 1, Math.min(low + sz * 2 - 1, n - 1));
            }
        }
    }
}
