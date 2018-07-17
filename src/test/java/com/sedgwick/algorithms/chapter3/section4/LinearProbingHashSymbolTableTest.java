package com.sedgwick.algorithms.chapter3.section4;

import com.sedgwick.algorithms.chapter3.AbstractSymbolTableTest;

public class LinearProbingHashSymbolTableTest extends AbstractSymbolTableTest {

    @Override
    public void init() {
        table = new LinearProbingHashSymbolTable<>();
    }
}