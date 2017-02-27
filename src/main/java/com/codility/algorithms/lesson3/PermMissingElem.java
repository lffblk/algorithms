package com.codility.algorithms.lesson3;

import java.util.*;

/**
 * A zero-indexed array A consisting of N different integers is given. The array contains integers in the range
 * [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Assume that:
 * - N is an integer within the range [0..100,000];
 * - the elements of A are all distinct;
 * - each element of array A is an integer within the range [1..(N + 1)].
 *
 * Complexity:
 * - expected worst-case time complexity is O(N);
 * - expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 *
 * Elements of input arrays can be modified.
 */
public class PermMissingElem {
    public static int permMissingElemFast(int[] a) {
        if (a.length == 0) return 1;
        if (a.length == 1) return a[0] == 1 ? 2 : 1;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != i + 1) return i + 1;
        }
        // last element missed
        return a.length + 1;
    }

    public static int permMissingElemSlow(int[] a) {
        if (a.length == 0) return 1;
        if (a.length == 1) return a[0] == 1 ? 2 : 1;
        Set<Integer> elements = new HashSet<>(a.length);
        for (int element : a) {
            elements.add(element);
        }

        for (int i = 1; i <= a.length; i++) {
            if (!elements.contains(i)) return i;
        }
        // last element missed
        return a.length + 1;
    }
}
