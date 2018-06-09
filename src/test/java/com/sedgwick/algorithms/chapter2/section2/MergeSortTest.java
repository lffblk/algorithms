package com.sedgwick.algorithms.chapter2.section2;

import com.sedgwick.algorithms.chapter2.AbstractSortTest;

public class MergeSortTest extends AbstractSortTest {

    @Override
    public void init() {
        sorter = new MergeSort<>();
    }
}