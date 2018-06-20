package com.sedgwick.algorithms.chapter1;

public interface Collection<Item> extends Iterable<Item> {

    boolean isEmpty();

    int size();
}
