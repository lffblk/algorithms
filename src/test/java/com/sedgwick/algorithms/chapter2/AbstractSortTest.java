package com.sedgwick.algorithms.chapter2;

import com.sedgwick.algorithms.libs.StdOut;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public abstract class AbstractSortTest {

    protected Sort<String> sorter;

    @Before
    public abstract void init();

    @Test
    public void stringArraySortTest() {
        String[] array = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        doTest(array);
    }

    private void doTest(String[] array) {
        StdOut.println(Arrays.toString(array));
        sorter.sort(array);
        assertTrue(sorter.isSorted(array));
        StdOut.println(Arrays.toString(array));
    }
}
