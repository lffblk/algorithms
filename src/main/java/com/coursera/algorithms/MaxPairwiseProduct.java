package com.coursera.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxPairwiseProduct {

    public static long maxPairwiseProductSlow(List<Integer> arr) {
        long result = 0;
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                long tempRes = (long) arr.get(i) * arr.get(j);
                if (result < tempRes) {
                    result = tempRes;
                }
            }
        }
        return result;
    }

    public static long maxPairwiseProductFast(List<Integer> arr) {
        int maxIndex1 = -1;
        int maxIndex2 = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (maxIndex1 < 0 || arr.get(i) > arr.get(maxIndex1)) {
                maxIndex1 = i;
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            if (maxIndex1 != i && (maxIndex2 < 0 || arr.get(i) > arr.get(maxIndex2))) {
                maxIndex2 = i;
            }
        }

        return (long) arr.get(maxIndex1) * arr.get(maxIndex2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(s.nextInt());
        }

        System.out.println(maxPairwiseProductFast(arr));
    }
}
