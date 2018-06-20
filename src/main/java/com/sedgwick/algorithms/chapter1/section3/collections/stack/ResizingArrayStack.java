package com.sedgwick.algorithms.chapter1.section3.collections.stack;

import com.sedgwick.algorithms.chapter1.ResizingArrayCollection;

import java.util.Iterator;

public class ResizingArrayStack<Item extends Comparable<Item>>
        extends ResizingArrayCollection<Item> implements Stack<Item> {

    @SuppressWarnings("unchecked")
    public ResizingArrayStack(int capacity) {
        super(capacity);
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
