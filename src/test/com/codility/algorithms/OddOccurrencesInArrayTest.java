package com.codility.algorithms;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class OddOccurrencesInArrayTest {

    public static void main(String[] args) {
        for (int n = 1; n < 100000; n = n + 2) {
            int[] a = fillArray(n);
            int result1 = OddOccurrencesInArray.getResultSlow(Arrays.copyOf(a, a.length));
            int result2 = OddOccurrencesInArray.getResultFast(Arrays.copyOf(a, a.length));
            if (result1 != result2) {
                System.out.println("Error! n = " + n + ", result1 = " + result1 + ", result2 = " + result2);
                break;
            }
            System.out.println("n = " + n + ", result = " + result1 + ", OK");
        }
    }

    private static int[] fillArray(int n) {
        int randomBound = 1000;
        Random random = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n - 1; i = i + 2) {
            int element = random.nextInt(randomBound);
            a[i] = element;
            a[i+1] = element;
        }
        a[n-1] = random.nextInt(randomBound);
        shuffleArray(a);
        System.out.println("shuffled = " + Arrays.toString(a));
        return a;
    }

    private static void shuffleArray(int[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
