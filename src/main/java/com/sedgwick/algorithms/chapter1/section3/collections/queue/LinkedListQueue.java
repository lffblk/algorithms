package com.sedgwick.algorithms.chapter1.section3.collections.queue;

import com.sedgwick.algorithms.chapter1.section3.collections.LinkedListCollection;
import com.sedgwick.algorithms.chapter1.section3.collections.LinkedListNode;

public class LinkedListQueue<Item> extends LinkedListCollection<Item> implements Queue<Item> {

    private LinkedListNode<Item> last;

    @Override
    public void enqueue(Item item) {
        LinkedListNode<Item> newLastNode = new LinkedListNode<>(item, null);
        if (isEmpty()) {
            first = newLastNode;
        }
        else {
            last.setNext(newLastNode);
        }
        last = newLastNode;
        size++;
    }

    @Override
    public Item dequeue() {
        Item item = popFirstElement();
        if (first == null) {
            last = null;
        }
        return item;
    }
}
