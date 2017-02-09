package com.codility.algorithms;

import java.util.*;

public class OddOccurrencesInArray {

    public static int getResultFast(int[] a) {
        Set<Integer> values = new HashSet<>();
        for (int element : a) {
            if (!values.contains(element)) {
                values.add(element);
            } else {
                values.remove(element);
            }
        }
        System.out.println("values = " + values);
        return values.iterator().next();
    }

    public static int getResultSlow(int[] a) {
        HashMap<Integer, Integer> existentElementsToCount = new HashMap<>();
        for (int element : a) {
            int count = 1;
            if (existentElementsToCount.keySet().contains(element)) {
                count += existentElementsToCount.get(element);
                if (count == 3) count = 1;
            }
            existentElementsToCount.put(element, count);
        }

        for (Integer key : existentElementsToCount.keySet()) {
            if (existentElementsToCount.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }
}
