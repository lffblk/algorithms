package com.sedgwick.algorithms.chapter1.section3.collections.stack;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Stack<Item> {

    private Item[] elements;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack(int capacity) {
        elements = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    public void push(Item item) {
        if (currentSize == elements.length) {
            resize(elements.length * 2);
        }
        elements[currentSize++] = item;
    }

    public Item pop() {
        Item item = elements[--currentSize];
        elements[currentSize] = null;
        if (currentSize > 0 && currentSize == elements.length / 4) {
            resize(elements.length / 2);
        }
        return item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        System.arraycopy(elements, 0, temp, 0, currentSize);
        elements = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = currentSize;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return elements[--i];
        }
    }
}
