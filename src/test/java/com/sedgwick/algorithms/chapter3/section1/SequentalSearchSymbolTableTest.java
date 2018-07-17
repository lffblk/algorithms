package com.sedgwick.algorithms.chapter3.section1;

import com.sedgwick.algorithms.chapter3.AbstractSymbolTableTest;

public class SequentalSearchSymbolTableTest extends AbstractSymbolTableTest {

    @Override
    public void init() {
        table = new SequentalSearchSymbolTable<>();
    }

}