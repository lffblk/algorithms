package com.codility.algorithms.lesson4;

import com.AbstractStressTest;
import com.TestUtils;
import org.junit.Test;

import java.util.Arrays;

public class MissingIntegerTest extends AbstractStressTest {

    private int[] a;

    @Test
    @Override
    public void run() {
        run(10000);
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
