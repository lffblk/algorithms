package com.codility.algorithms.lesson2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class CyclicRotationTest {
    @Test
    public void cyclicRotationStressTest() {
        Random random = new Random();
        for (int iter = 0; iter < 10000; iter++) {
            int n = random.nextInt(101);
            int k = random.nextInt(101);
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = random.nextInt(1001);
            }

            int[] result1 = CyclicRotation.cyclicRotationSlow(Arrays.copyOf(a, n), k);
            int[] result2 = CyclicRotation.cyclicRotationFast(Arrays.copyOf(a, n), k);

            if (!Arrays.equals(result1, result2)) {
                System.out.println("Error! n = " + n + ", k = " + k + ", a = " + Arrays.toString(a)
                        + ", result1 = " + Arrays.toString(result1) + ", result2 = " + Arrays.toString(result2));
                break;
            }
        }
    }
}
