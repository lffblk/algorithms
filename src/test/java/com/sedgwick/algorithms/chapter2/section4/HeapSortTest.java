package com.sedgwick.algorithms.chapter2.section4;

import com.sedgwick.algorithms.chapter2.AbstractSortTest;

public class HeapSortTest extends AbstractSortTest {

    @Override
    public void init() {
        sorter = new HeapSort<>();
    }
}