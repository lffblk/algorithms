package com.sedgwick.algorithms.chapter1.section3.collections.stack;

import com.sedgwick.algorithms.libs.StdOut;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class StackTest {
    Stack<String> stack;

    @Before
    public abstract void init();

    @Test
    public void doTest() {
        String[] input = "to be or not to - be - - that - - - is".split(" ");
        String expectedPoppedElements = "to be not that or be";
        String expectedElementsInStack = "is to";
        StringBuilder poppedElementsBuilder = new StringBuilder();
        for (String item: input) {
            if (!item.equals("-")) {
                stack.push(item);
            }
            else if (!stack.isEmpty()) {
                String element = stack.pop();
                if (poppedElementsBuilder.length() > 0) {
                    poppedElementsBuilder.append(" ");
                }
                poppedElementsBuilder.append(element);
            }
        }
        String actualPoppedElements = poppedElementsBuilder.toString();
        StdOut.println("Popped elements: " + actualPoppedElements);
        assertEquals(expectedPoppedElements, actualPoppedElements);

        StdOut.println("Current stack size: " + stack.size());
        assertEquals(2, stack.size());

        StringBuilder elementsInStackBuilder = new StringBuilder();
        for (String element: stack) {
            if (elementsInStackBuilder.length() > 0) {
                elementsInStackBuilder.append(" ");
            }
            elementsInStackBuilder.append(element);
        }
        String actualElementsInStack = elementsInStackBuilder.toString();
        StdOut.println("Elements in stack: " + actualElementsInStack);
        assertEquals(expectedElementsInStack, actualElementsInStack);
    }
}
