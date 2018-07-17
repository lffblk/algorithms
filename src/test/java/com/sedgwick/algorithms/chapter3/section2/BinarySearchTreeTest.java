package com.sedgwick.algorithms.chapter3.section2;

import com.sedgwick.algorithms.chapter3.AbstractSymbolTableTest;

public class BinarySearchTreeTest extends AbstractSymbolTableTest {

    @Override
    public void init() {
        table = new BinarySearchTree<>();
    }
}