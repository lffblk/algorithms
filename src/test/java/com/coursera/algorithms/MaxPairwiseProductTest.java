package com.coursera.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaxPairwiseProductTest {

    @Test
    public void stressTestMaxPairwiseProduct() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int n = random.nextInt(10000) + 2;

            List<Integer> arr = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                arr.add(random.nextInt(100000));
            }

            long res1 = MaxPairwiseProduct.maxPairwiseProductSlow(arr);
            long res2 = MaxPairwiseProduct.maxPairwiseProductFast(arr);

            if (res1 != res2) {
                System.out.println("Wrong Answer: res1 = " + res1 + ", res2 = " + res2);
                break;
            }
        }
    }
}
