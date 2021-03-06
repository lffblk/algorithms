package com.codility.algorithms.lesson3;

import com.AbstractStressTest;
import org.junit.Test;

import static com.TestUtils.getRandom;

public class FrogJmpTest extends AbstractStressTest {

    private int x;
    private int y;
    private int d;

    @Test
    @Override
    public void run() {
        run(1000000);
    }

    @Override
    public void generateArguments() {
        y = getRandom().nextInt(100) + 1;
        x = getRandom().nextInt(y) + 1;
        d = getRandom().nextInt(100) + 1;
    }

    @Override
    public Object getResultSlow() {
        int mutableX = x;
        int mutableY = y;
        int mutableD = d;
        return FrogJmp.frogJmpSlow(mutableX, mutableY, mutableD);
    }

    @Override
    public Object getResultFast() {
        int mutableX = x;
        int mutableY = y;
        int mutableD = d;
        return FrogJmp.frogJmpFast(mutableX, mutableY, mutableD);
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! x = " + x + ", y = " + y + ", d = " + d
                + ", slowResult = " + slowResult + ", fastResult = " + fastResult;
    }
}
