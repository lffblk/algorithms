package com.codility.algorithms;

public class BinaryGapTest {
    public static void main(String[] args) {
        for (int n = 1; n < Integer.MAX_VALUE; n++) {
            int binaryGap1 = BinaryGap.getBinaryGapSlow(n);
            int binaryGap2 = BinaryGap.getBinaryGapFast(n);
            if (binaryGap1 != binaryGap2) {
                System.out.println("Error! n = " + n + ", binaryGap1 = " + binaryGap1 + ", binaryGap2 = " + binaryGap2);
                break;
            }
            System.out.println("n = " + n + ", OK");
        }
    }
}
