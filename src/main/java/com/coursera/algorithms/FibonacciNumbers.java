package com.coursera.algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciNumbers {
    public static BigInteger getFibonacciNumberSlow(int n) {
        if (n <= 1) return BigInteger.valueOf(n);
        return getFibonacciNumberSlow(n - 1).add(getFibonacciNumberSlow(n - 2));
    }

    public static BigInteger getFibonacciNumberFast(int n) {
        List<BigInteger> fibonacciNumbers = new ArrayList<>(n);
        fibonacciNumbers.add(BigInteger.ZERO);
        fibonacciNumbers.add(BigInteger.ONE);
        for (int i = 1; i < n; i++) {
            fibonacciNumbers.add(fibonacciNumbers.get(i).add(fibonacciNumbers.get(i - 1)));
        }
        return fibonacciNumbers.get(n);
    }

    public static void main(String[] args) {
        System.out.println("n = 100, " + getFibonacciNumberFast(100));
    }
}
