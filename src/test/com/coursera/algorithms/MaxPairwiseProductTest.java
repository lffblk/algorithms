package com.coursera.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaxPairwiseProductTest {
    public static void main(String[] args) {
        while (true) {
            Random random = new Random();
            int n = random.nextInt(10000) + 2;
            System.out.println("n = " + n);

            List<Integer> arr = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                arr.add(random.nextInt(100000));
            }
            System.out.println("arr = " + arr);

            long res1 = MaxPairwiseProduct.maxPairwiseProductSlow(arr);
            long res2 = MaxPairwiseProduct.maxPairwiseProductFast(arr);

            if (res1 != res2) {
                System.out.println("Wrong Answer: res1 = " + res1 + ", res2 = " + res2);
                break;
            } else {
                System.out.println("OK");
            }
        }
    }
}
