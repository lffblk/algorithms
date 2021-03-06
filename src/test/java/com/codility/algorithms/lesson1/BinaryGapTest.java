package com.codility.algorithms.lesson1;

import com.AbstractStressTest;
import org.junit.Test;

import static com.TestUtils.getRandom;

public class BinaryGapTest extends AbstractStressTest {

    private int n;

    @Test
    @Override
    public void run() {
        run(1000000);
    }

    @Override
    public void generateArguments() {
        n = getRandom().nextInt(1000000);
    }

    @Override
    public Object getResultSlow() {
        return BinaryGap.getBinaryGapSlow(n);
    }

    @Override
    public Object getResultFast() {
        return BinaryGap.getBinaryGapFast(n);
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! n = " + n + ", slowResult = " + slowResult + ", fastResult = " + fastResult;
    }
}
