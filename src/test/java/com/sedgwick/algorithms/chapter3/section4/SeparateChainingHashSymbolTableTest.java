package com.sedgwick.algorithms.chapter3.section4;

import com.sedgwick.algorithms.chapter3.AbstractSymbolTableTest;

public class SeparateChainingHashSymbolTableTest extends AbstractSymbolTableTest {

    @Override
    public void init() {
        table = new SeparateChainingHashSymbolTable<>(13);
    }
}