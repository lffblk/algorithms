package com.sedgwick.algorithms.chapter2;

public abstract class AbstractSort<Item extends Comparable<Item>> implements Sort<Item> {

    protected boolean less(Item a, Item b) {
        return a.compareTo(b) < 0;
    }

    protected void exchange(Item[] array, int i, int j) {
        Item temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public boolean isSorted(Item[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
