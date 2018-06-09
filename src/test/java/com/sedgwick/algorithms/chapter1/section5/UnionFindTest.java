package com.sedgwick.algorithms.chapter1.section5;

import com.sedgwick.algorithms.chapter1.section3.collections.queue.LinkedListQueue;
import com.sedgwick.algorithms.chapter1.section3.collections.queue.Queue;
import com.sedgwick.algorithms.libs.In;
import com.sedgwick.algorithms.libs.StdOut;
import com.sedgwick.algorithms.libs.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class UnionFindTest {
    UnionFind uf;

    abstract void init(int n);

    @Test
    public void testTinyInput() {
        doTest("tinyUF.txt", 2);
    }

    @Test
    public void testMediumInput() {
        doTest("mediumUF.txt", 3);
    }

    void doTest(String fileName, int expectedComponentsCount) {
        Stopwatch stopwatch = new Stopwatch();
        PairsContainer inputsContainer = createInput(fileName);
        Queue<Pair> input = inputsContainer.input;
        init(inputsContainer.maxNumber);

        for (Pair pair: input) {
            if (uf.connected(pair.p, pair.q)) {
                continue;
            }
            uf.union(pair.p, pair.q);
        }
        StdOut.println("Components count: " + uf.count());
        assertEquals(expectedComponentsCount, uf.count());
        System.out.println("Time: " + stopwatch.elapsedTime() + " s");
    }

    private PairsContainer createInput(String inputFileName) {
        PairsContainer result = new PairsContainer();
        Queue<Pair> input = new LinkedListQueue<>();
        try {
            In in = new In("./" + inputFileName);
            if (!in.isEmpty()) {
                result.maxNumber = Integer.parseInt(in.readLine());
            }
            while (!in.isEmpty()) {
                String[] pairStr = in.readLine().split(" ");
                Pair pair = new Pair(Integer.parseInt(pairStr[0]), Integer.parseInt(pairStr[1]));
                input.enqueue(pair);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        result.input = input;
        return result;
    }

    private class PairsContainer {
        Queue<Pair> input;
        int maxNumber;
    }

    private class Pair {
        int p;
        int q;

        Pair(int p, int q) {
            this.p = p;
            this.q = q;
        }
    }
}
