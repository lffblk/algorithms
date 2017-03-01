package com.codility.algorithms.lesson2;

import com.StressTestSuit;
import com.TestUtils;
import com.Tester;
import org.junit.Test;

import java.util.Arrays;

import static com.TestUtils.getRandom;

public class CyclicRotationTest implements StressTestSuit {

    private int k;
    private int[] a;

    @Test
    @Override
    public void run() {
        Tester.test(10000, this);
    }

    @Override
    public void generateArguments() {
        k = getRandom().nextInt(101);
        a = TestUtils.generateRandomArray(101, 1001);
    }

    @Override
    public Object getResultSlow() {
        return CyclicRotation.cyclicRotationSlow(Arrays.copyOf(a, a.length), k);
    }

    @Override
    public Object getResultFast() {
        return CyclicRotation.cyclicRotationFast(Arrays.copyOf(a, a.length), k);
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! n = " + a.length + ", k = " + k + ", a = " + Arrays.toString(a)
                + ", slowResult = " + Arrays.toString((int[])slowResult) + ", fastResult = " + Arrays.toString((int[])fastResult);
    }
}
