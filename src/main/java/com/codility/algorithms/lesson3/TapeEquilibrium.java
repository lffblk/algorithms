package com.codility.algorithms.lesson3;

import java.util.Arrays;

/*
 * A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
 *
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1]
 * and A[P], A[P + 1], ..., A[N − 1].
 *
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 *
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 *
 * For example, consider array A such that:
 *  A[0] = 3
 *  A[1] = 1
 *  A[2] = 2
 *  A[3] = 4
 *  A[4] = 3
 *
 * We can split this tape in four places:
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 *
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.
 *
 * For example, given:
 *  A[0] = 3
 *  A[1] = 1
 *  A[2] = 2
 *  A[3] = 4
 *  A[4] = 3
 * the function should return 1, as explained above.
 *
 * Assume that:
 * - N is an integer within the range [2..100,000];
 * - each element of array A is an integer within the range [−1,000..1,000].
 *
 * Complexity:
 * - expected worst-case time complexity is O(N);
 * - expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 *
 * Elements of input arrays can be modified.
 */
public class TapeEquilibrium {
    public static int tapeEquilibriumFast(int[] a) {
        int[] lefts = new int[a.length - 1];
        int[] rights = new int[a.length - 1];
        int result = Integer.MAX_VALUE;

        for (int p = 1, k = a.length - 1; p < a.length; p++, k--) {
            lefts[p - 1] = ((p - 2 >= 0) ? lefts[p - 2] : 0) + a[p - 1];
            rights[k - 1] = ((k >= a.length - 1) ? 0 : rights[k]) + a[k];
        }

        for (int i = 0; i < lefts.length; i++) {
            int currentDifference = Math.abs(lefts[i] - rights[i]);
            if (currentDifference < result) result = currentDifference;
        }

        return result;
    }

    public static int tapeEquilibriumSlow(int[] a) {
        int[] result = new int[a.length];
        result[0] = Integer.MAX_VALUE;
        for (int p = 1; p < a.length; p++) {
            int leftSum = 0;
            for (int i = 0; i < p; i++) {
                leftSum += a[i];
            }
            int rightSum = 0;
            for (int i = p; i < a.length; i++) {
                rightSum += a[i];
            }
            result[p] = Math.abs(leftSum - rightSum);
        }
        Arrays.sort(result);
        return result[0];
    }
}
