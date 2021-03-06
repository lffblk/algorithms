package com.coursera.algorithms;

import com.AbstractStressTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.TestUtils.getRandom;

public class MaxPairwiseProductTest extends AbstractStressTest {

    private List<Integer> arr;

    @Test
    @Override
    public void run() {
        run(100);
    }

    @Override
    public void generateArguments() {
        int n = getRandom().nextInt(10000) + 2;

        arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(getRandom().nextInt(100000));
        }
    }

    @Override
    public Object getResultSlow() {
        return MaxPairwiseProduct.maxPairwiseProductSlow(arr);
    }

    @Override
    public Object getResultFast() {
        return MaxPairwiseProduct.maxPairwiseProductFast(arr);
    }

    @Override
    public String generateExceptionMessage(Object slowResult, Object fastResult) {
        return "Error! arr = " + arr + ", slowResult = " + slowResult + ", fastResult = " + fastResult;
    }
}
