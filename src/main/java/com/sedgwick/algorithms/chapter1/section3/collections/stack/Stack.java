package com.sedgwick.algorithms.chapter1.section3.collections.stack;

import com.sedgwick.algorithms.chapter1.Collection;

public interface Stack<Item> extends Collection<Item> {

    void push(Item item);

    Item pop();
}
