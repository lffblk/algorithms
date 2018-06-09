package com.sedgwick.algorithms.chapter1.section3.collections.queue;

import com.sedgwick.algorithms.libs.StdOut;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListQueueTest {

    private Queue<String> queue;

    @Before
    public void init() {
        queue = new LinkedListQueue<>();
    }

    @Test
    public void test() {
        String[] input = "to be or not to - be - - that - - - is".split(" ");
        String expectedPoppedElements = "to be or not to be";
        String expectedElementsInQueue = "that is";
        StringBuilder poppedElementsBuilder = new StringBuilder();
        for (String item: input) {
            if (!item.equals("-")) {
                queue.enqueue(item);
            }
            else if (!queue.isEmpty()) {
                String element = queue.dequeue();
                if (poppedElementsBuilder.length() > 0) {
                    poppedElementsBuilder.append(" ");
                }
                poppedElementsBuilder.append(element);
            }
        }

        String actualPoppedElements = poppedElementsBuilder.toString();
        StdOut.println("Popped elements: " + actualPoppedElements);
        assertEquals(expectedPoppedElements, actualPoppedElements);

        StdOut.println("Current queue size: " + queue.size());
        assertEquals(2, queue.size());

        StringBuilder elementsInQueueBuilder = new StringBuilder();
        for (String element: queue) {
            if (elementsInQueueBuilder.length() > 0) {
                elementsInQueueBuilder.append(" ");
            }
            elementsInQueueBuilder.append(element);
        }
        String actualElementsInQueue = elementsInQueueBuilder.toString();
        StdOut.println("Elements in queue: " + actualElementsInQueue);
        assertEquals(expectedElementsInQueue, actualElementsInQueue);
    }
}