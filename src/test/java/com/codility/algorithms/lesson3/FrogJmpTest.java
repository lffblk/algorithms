package com.codility.algorithms.lesson3;

import org.junit.Test;

import java.util.Random;

public class FrogJmpTest {
    @Test
    public void frogJumpStressTest() {
        Random random = new Random();
        for(int i = 0; i < 1000000; i++) {
            int etalonY = random.nextInt(100) + 1;
            int etalonX = random.nextInt(etalonY) + 1;
            int etalonD = random.nextInt(100) + 1;

            int x1 = etalonX;
            int x2 = etalonX;
            int y1 = etalonY;
            int y2 = etalonY;
            int d1 = etalonD;
            int d2 = etalonD;

            int result1 = FrogJmp.frogJmpSlow(x1, y1, d1);
            int result2 = FrogJmp.frogJmpFast(x2, y2, d2);

            if (result1 != result2) {
                System.out.println("Error! x = " + etalonX + ", y = " + etalonY + ", d = " + etalonD
                        + ", result1 = " + result1 + ", result2 = " + result2);
                break;
            }
        }
    }
}
