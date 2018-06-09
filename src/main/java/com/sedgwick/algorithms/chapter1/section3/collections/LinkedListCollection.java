package com.sedgwick.algorithms.chapter1.section3.collections;

import java.util.Iterator;

public class LinkedListCollection<Item> {

    protected LinkedListNode<Item> first;
    protected int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    protected void pushElement(Item item) {
        first = new LinkedListNode<>(item, first);
        size++;
    }

    protected Item popFirstElement() {
        if (first == null) {
            return null;
        }
        Item item = first.getItem();
        first = first.getNext();
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements Iterator<Item> {
        private LinkedListNode<Item> currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            Item item = currentNode.getItem();
            currentNode = currentNode.getNext();
            return item;
        }
    }
}
