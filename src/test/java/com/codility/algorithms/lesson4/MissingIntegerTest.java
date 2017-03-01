package com.codility.algorithms.lesson4;

import com.StressTestSuit;
import com.TestUtils;
import com.Tester;
import org.junit.Test;

import java.util.Arrays;

public class MissingIntegerTest implements StressTestSuit {

    private int[] a;

    @Test
    @Override
    public void run() {
        Tester.test(10000, this);
    }

    @Override
    public void generateArguments() {
        a = TestUtils.generateRandomArray(100, 1000);
    }

    @Override
    public Object getResultSlow() {
        return MissingInteger.missingIntegerSlow(a);
    }

    @Override
    public Object getResultFast() {
        return MissingInteger.missingIntegerFast(a);
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! a = " + Arrays.toString(a) + ", slowResult = " + slowResult + ", fastResult = " + fastResult;
    }
}
