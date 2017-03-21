package com.coursera.algorithms;

import com.AbstractStressTest;
import org.junit.Test;

import static com.TestUtils.getRandom;

public class FibonacciNumbersTest extends AbstractStressTest {

    private int n;

    @Test
    @Override
    public void run() {
        run(35);
    }

    @Override
    public void generateArguments() {
        n = getRandom().nextInt(35);
    }

    @Override
    public Object getResultSlow() {
        return FibonacciNumbers.getFibonacciNumberSlow(n);
    }

    @Override
    public Object getResultFast() {
        return FibonacciNumbers.getFibonacciNumberFast(n);
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! n = " + n + ", slowResult = " + slowResult + ", fastResult = " + fastResult;
    }
}
