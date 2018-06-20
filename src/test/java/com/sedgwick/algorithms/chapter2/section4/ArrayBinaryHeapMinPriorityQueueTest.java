package com.sedgwick.algorithms.chapter2.section4;

import com.google.common.collect.Lists;
import com.sedgwick.algorithms.chapter1.section3.collections.stack.LinkedListStack;
import com.sedgwick.algorithms.chapter1.section3.collections.stack.Stack;
import com.sedgwick.algorithms.chapter2.MinPriorityQueue;
import com.sedgwick.algorithms.libs.In;
import com.sedgwick.algorithms.libs.StdOut;
import com.sedgwick.algorithms.model.Transaction;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayBinaryHeapMinPriorityQueueTest {

    @Test
    public void testTransactionsQueue() {
        int m = 5;
        MinPriorityQueue<Transaction> queue = new ArrayBinaryHeapMinPriorityQueue<>(m + 1);
        In in = new In("./tinyBatch.txt");
        while (!in.isEmpty()) {
            queue.insert(new Transaction(in.readLine()));
            if (queue.size() > m) {
                queue.deleteMin();
            }
        }

        Stack<Transaction> stack = new LinkedListStack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.deleteMin());
        }
        assertEquals(5, stack.size());

        List<Transaction> expectedResult = createExpectedResult();
        Iterator<Transaction> erIterator = expectedResult.iterator();
        for (Transaction t : stack) {
            StdOut.println(t);
            assertEquals(erIterator.next(), t);
        }
    }

    private List<Transaction> createExpectedResult() {
        List<Transaction> expectedResult = Lists.newLinkedList();

        expectedResult.add(new Transaction("Thompson 2/27/2000 4747.08"));
        expectedResult.add(new Transaction("vonNeumann 2/12/1994 4732.35"));
        expectedResult.add(new Transaction("vonNeumann 1/11/1999 4409.74"));
        expectedResult.add(new Transaction("Hoare 8/18/1992 4381.21"));
        expectedResult.add(new Transaction("vonNeumann 3/26/2002 4121.85"));

        return expectedResult;
    }
}