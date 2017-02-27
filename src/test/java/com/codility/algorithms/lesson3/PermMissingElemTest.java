package com.codility.algorithms.lesson3;

import com.TestUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class PermMissingElemTest {
    @Test
    public void permMissingElemStressTest() {
        Random random = new Random();
        for(int iter = 0; iter < 1000; iter++) {
            int n = random.nextInt(10) + 3;
            int k = random.nextInt(n);
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = i == k ? n + 1 : i + 1;
            }
            TestUtils.shuffleArray(a);
            int result1 = PermMissingElem.permMissingElemSlow(Arrays.copyOf(a, a.length));
            int result2 = PermMissingElem.permMissingElemFast(Arrays.copyOf(a, a.length));
            if (result1 != result2) {
                System.out.println("Error! a = " + Arrays.toString(a) + ", result1 = " + result1 + ", result2 = " + result2);
                break;
            }
        }
    }
}
