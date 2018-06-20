package com.sedgwick.algorithms.chapter1;

public class ResizingArrayCollection<Item extends Comparable<Item>> {

    protected Item[] elements;
    protected int currentSize = 0;

    @SuppressWarnings("unchecked")
    public ResizingArrayCollection(int capacity) {
        elements = (Item[]) new Comparable[capacity];
    }

    @SuppressWarnings("unchecked")
    protected void resize(int newSize) {
        Item[] temp = (Item[]) new Comparable[newSize];
        System.arraycopy(elements, 0, temp, 0, currentSize);
        elements = temp;
    }
}
