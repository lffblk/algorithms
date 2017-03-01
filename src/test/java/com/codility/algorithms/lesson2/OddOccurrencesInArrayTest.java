package com.codility.algorithms.lesson2;

import com.StressTestSuit;
import com.TestUtils;
import com.Tester;
import org.junit.Test;

import java.util.*;

import static com.TestUtils.getRandom;

public class OddOccurrencesInArrayTest implements StressTestSuit {

    private int n;
    private int[] a;

    private int[] fillArray(int n) {
        int randomBound = 1000;
        Random random = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n - 1; i = i + 2) {
            int element = random.nextInt(randomBound);
            a[i] = element;
            a[i+1] = element;
        }
        a[n-1] = random.nextInt(randomBound);
        TestUtils.shuffleArray(a);
        return a;
    }

    @Test
    @Override
    public void run() {
        Tester.test(10000, this);
    }

    @Override
    public void generateArguments() {
        n = getRandom().nextInt(10000) + 1;
        if (n % 2 == 0) n++;
        a = fillArray(n);
    }

    @Override
    public Object getResultSlow() {
        return OddOccurrencesInArray.getResultSlow(Arrays.copyOf(a, a.length));
    }

    @Override
    public Object getResultFast() {
        return OddOccurrencesInArray.getResultFast(Arrays.copyOf(a, a.length));
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! n = " + n + ", a = " + Arrays.toString(a) + ", slowResult = " +
                slowResult + ", fastResult = " + fastResult;
    }
}
