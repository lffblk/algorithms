package com.sedgwick.algorithms.chapter2.section1;

import com.sedgwick.algorithms.chapter2.AbstractSortTest;

public class SelectionSortTest extends AbstractSortTest {

    @Override
    public void init() {
        sorter = new SelectionSort<>();
    }
}