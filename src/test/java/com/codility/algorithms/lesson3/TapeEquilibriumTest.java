package com.codility.algorithms.lesson3;

import com.StressTestSuit;
import com.TestUtils;
import com.Tester;
import org.junit.Test;

import java.util.Arrays;

public class TapeEquilibriumTest implements StressTestSuit {

    private int[] a;

    @Test
    @Override
    public void run() {
        Tester.test(100000, this);
    }

    @Override
    public void generateArguments() {
        a = TestUtils.generateRandomArray(1001, 1001);
    }

    @Override
    public Object getResultSlow() {
        return TapeEquilibrium.tapeEquilibriumSlow(Arrays.copyOf(a, a.length));
    }

    @Override
    public Object getResultFast() {
        return TapeEquilibrium.tapeEquilibriumFast(Arrays.copyOf(a, a.length));
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! n = " + a.length + ", a = " + Arrays.toString(a)
                + ", slowResult = " + slowResult + ", fastResult = " + fastResult;
    }
}
