package com.codility.algorithms.lesson3;

import com.AbstractStressTest;
import com.TestUtils;
import org.junit.Test;

import java.util.Arrays;

import static com.TestUtils.getRandom;

public class PermMissingElemTest extends AbstractStressTest {

    private int[] a;

    @Test
    @Override
    public void run() {
        run(1000);
    }

    @Override
    public void generateArguments() {
        int n = getRandom().nextInt(10) + 3;
        int k = getRandom().nextInt(n);
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i == k ? n + 1 : i + 1;
        }
        TestUtils.shuffleArray(a);
    }

    @Override
    public Object getResultSlow() {
        return PermMissingElem.permMissingElemSlow(Arrays.copyOf(a, a.length));
    }

    @Override
    public Object getResultFast() {
        return PermMissingElem.permMissingElemFast(Arrays.copyOf(a, a.length));
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! a = " + Arrays.toString(a) + ", slowResult = " + slowResult + ", fastResult = " + fastResult;
    }
}
