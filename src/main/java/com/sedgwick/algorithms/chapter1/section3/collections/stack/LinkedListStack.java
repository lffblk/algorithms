package com.sedgwick.algorithms.chapter1.section3.collections.stack;

import com.sedgwick.algorithms.chapter1.section3.collections.LinkedListCollection;

public class LinkedListStack<Item> extends LinkedListCollection<Item> implements Stack<Item> {

    public void push(Item item) {
        pushElement(item);
    }

    @Override
    public Item pop() {
        return popFirstElement();
    }
}
