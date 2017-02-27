package com.coursera.algorithms;

import org.junit.Test;

import java.math.BigInteger;

public class FibonacciNumbersTest {

    @Test
    public void stressTestFibonacciNumbers() {
        for (int n = 0; n < 35; n++) {
            BigInteger fibonacciNumber1 = FibonacciNumbers.getFibonacciNumberSlow(n);
            BigInteger fibonacciNumber2 = FibonacciNumbers.getFibonacciNumberFast(n);
            if (!fibonacciNumber1.equals(fibonacciNumber2)) {
                System.out.println("Error! n = " + n + ", fibonacciNumber1 = " + fibonacciNumber1
                        + ", fibonacciNumber2 = " + fibonacciNumber2);
                break;
            }
        }
    }
}
