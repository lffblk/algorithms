package com.sedgwick.algorithms.chapter1.section3.collections.bag;

import com.sedgwick.algorithms.libs.StdOut;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class LinkedListBagTest {

    private Bag<String> bag;

    @Before
    public void init() {
        bag = new LinkedListBag<>();
    }

    @Test
    public void test() {
        String[] input = "to be or not to be that is".split(" ");
        List<String> expectedElementsInBag = new ArrayList<>(Arrays.asList(input));

        for (String item: input) {
            bag.add(item);
        }

        StdOut.println("Current bag size: " + bag.size());
        assertEquals(8, bag.size());

        List<String> actualElementsInBag = new ArrayList<>();
        for (String element: bag) {
            actualElementsInBag.add(element);
        }
        StdOut.println("Elements in bag: " + actualElementsInBag);
        assertTrue(actualElementsInBag.containsAll(expectedElementsInBag));
    }
}