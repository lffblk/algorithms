package com.sedgwick.algorithms.chapter2.section1;

import com.sedgwick.algorithms.chapter2.AbstractSortTest;

public class InsertionSortTest extends AbstractSortTest {

    @Override
    public void init() {
        sorter = new InsertionSort<>();
    }
}