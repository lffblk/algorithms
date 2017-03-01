package com;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class TestUtils {
    private static final Random RANDOM = ThreadLocalRandom.current();

    public static void shuffleArray(int[] ar)
    {
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = RANDOM.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static int[] generateRandomArray(int sizeBound, int bound) {
        int size = RANDOM.nextInt(sizeBound) + 1;
        int a[] = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = RANDOM.nextInt(bound);
        }
        return a;
    }

    public static Random getRandom() {
        return RANDOM;
    }
}
