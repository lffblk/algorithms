package com.codility.algorithms.lesson3;

import com.StressTestSuit;
import com.TestUtils;
import com.Tester;
import org.junit.Test;

import java.util.Arrays;

import static com.TestUtils.getRandom;

public class PermMissingElemTest implements StressTestSuit {

    private int[] a;

    @Test
    @Override
    public void run() {
        Tester.test(1000, this);
    }

    @Override
    public void generateArguments() {
        int n = getRandom().nextInt(10) + 3;
        int k = getRandom().nextInt(n);
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i == k ? n + 1 : i + 1;
        }
        TestUtils.shuffleArray(a);
    }

    @Override
    public Object getResultSlow() {
        return PermMissingElem.permMissingElemSlow(Arrays.copyOf(a, a.length));
    }

    @Override
    public Object getResultFast() {
        return PermMissingElem.permMissingElemFast(Arrays.copyOf(a, a.length));
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! a = " + Arrays.toString(a) + ", slowResult = " + slowResult + ", fastResult = " + fastResult;
    }
}
