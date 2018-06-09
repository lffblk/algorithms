package com.sedgwick.algorithms.chapter1.section3.collections;

public interface Collection<Item> extends Iterable<Item> {

    boolean isEmpty();

    int size();
}
