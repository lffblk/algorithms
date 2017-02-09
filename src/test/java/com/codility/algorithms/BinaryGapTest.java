package com.codility.algorithms;

import org.junit.Test;

public class BinaryGapTest {

    @Test
    public void stressTestBinaryGap() {
        for (int n = 1; n < 10000000; n++) {
            int binaryGap1 = BinaryGap.getBinaryGapSlow(n);
            int binaryGap2 = BinaryGap.getBinaryGapFast(n);
            if (binaryGap1 != binaryGap2) {
                System.out.println("Error! n = " + n + ", binaryGap1 = " + binaryGap1 + ", binaryGap2 = " + binaryGap2);
                break;
            }
        }
    }
}
