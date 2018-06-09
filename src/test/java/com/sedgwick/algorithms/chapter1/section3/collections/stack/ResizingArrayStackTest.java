package com.sedgwick.algorithms.chapter1.section3.collections.stack;

public class ResizingArrayStackTest extends StackTest {
    @Override
    public void init() {
        stack = new ResizingArrayStack<>(100);
    }
}