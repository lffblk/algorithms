package com.sedgwick.algorithms.chapter1.section3.collections.stack;

public class LinkedListStackTest extends StackTest {
    @Override
    public void init() {
        stack = new LinkedListStack<>();
    }
}
