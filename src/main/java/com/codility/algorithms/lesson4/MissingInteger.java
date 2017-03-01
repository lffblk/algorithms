package com.codility.algorithms.lesson4;

import java.util.Arrays;

/**
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0)
 * that does not occur in A.
 *
 * For example, given:
 * A[0] = 1
 * A[1] = 3
 * A[2] = 6
 * A[3] = 4
 * A[4] = 1
 * A[5] = 2
 * the function should return 5.
 *
 * Assume that:
 * - N is an integer within the range [1..100,000];
 * - each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 *
 * Complexity:
 * - expected worst-case time complexity is O(N);
 * - expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 *
 * Elements of input arrays can be modified.
 */
public class MissingInteger {
    public static int missingIntegerFast(int[] a) {
        int[] counts = new int[a.length + 1];
        for (int element : a) {
            if (element < a.length + 1) {
                counts[element]++;
            }
        }

        int result = 1;
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("counts = " + Arrays.toString(counts));
        System.out.println("result = " + result);

        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) return i;
            if (counts[i] == result) result++;
        }
        return result;
    }

    public static int missingIntegerSlow(int[] a) {
        Arrays.sort(a);
        int result = 1;
        for (int element : a) {
            if (element > 0 && element == result) {
                result++;
            }
        }
        return result;
    }
}
