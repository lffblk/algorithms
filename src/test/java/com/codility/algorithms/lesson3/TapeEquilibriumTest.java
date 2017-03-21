package com.codility.algorithms.lesson3;

import com.AbstractStressTest;
import com.TestUtils;
import org.junit.Test;

import java.util.Arrays;

public class TapeEquilibriumTest extends AbstractStressTest {

    private int[] a;

    @Test
    @Override
    public void run() {
        run(100000);
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
