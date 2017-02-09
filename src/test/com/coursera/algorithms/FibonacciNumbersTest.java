package com.coursera.algorithms;

import java.math.BigInteger;

public class FibonacciNumbersTest {
    public static void main(String[] args) {
        for (int n = 0; n < 45; n++) {
            BigInteger fibonacciNumber1 = FibonacciNumbers.getFibonacciNumberSlow(n);
            BigInteger fibonacciNumber2 = FibonacciNumbers.getFibonacciNumberFast(n);
            if (!fibonacciNumber1.equals(fibonacciNumber2)) {
                System.out.println("Error! n = " + n + ", fibonacciNumber1 = " + fibonacciNumber1
                        + ", fibonacciNumber2 = " + fibonacciNumber2);
                break;
            }
            System.out.println("n = " + n + ", OK");
        }
    }
}
