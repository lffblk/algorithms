package com.sedgwick.algorithms.chapter3.section3;

import com.sedgwick.algorithms.chapter3.AbstractSymbolTableTest;

public class RedBlackBinarySearchTreeTest extends AbstractSymbolTableTest {

    @Override
    public void init() {
        table = new RedBlackBinarySearchTree<>();
    }
}