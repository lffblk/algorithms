package com.codility.algorithms.lesson3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class TapeEquilibriumTest {
    @Test
    public void tapeEquilibriumStressTest() {
        Random random = new Random();
        for(int i = 0; i < 100000; i++) {
            int n = random.nextInt(999) + 2;
            int[] a = new int[n];
            for (int k = 0; k < n; k++) {
                a[k] = random.nextInt(1001);
            }

            int result1 = TapeEquilibrium.tapeEquilibriumSlow(Arrays.copyOf(a, n));
            int result2 = TapeEquilibrium.tapeEquilibriumFast(Arrays.copyOf(a, n));

            if (result1 != result2) {
                System.out.println("Error! n = " + n + ", a = " + Arrays.toString(a)
                        + ", result1 = " + result1 + ", result2 = " + result2);
                break;
            }
        }
    }
}
