package com.sedgwick.algorithms.chapter2.section3;

import com.sedgwick.algorithms.chapter2.AbstractSortTest;
import com.sedgwick.algorithms.chapter2.section3.QuickSort;

public class QuickSortTest extends AbstractSortTest {

    @Override
    public void init() {
        sorter = new QuickSort<>();
    }
}