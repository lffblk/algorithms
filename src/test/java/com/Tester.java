package com;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {
    public static void test(int iterationsCount, StressTestSuit test) {
        for(int i = 0; i < iterationsCount; i++) {
            test.generateArguments();
            Object slowResult = test.getResultSlow();
            Object fastResult = test.getResultFast();
            boolean areResultsEquals = slowResult.getClass().isArray()
                    ? areArraysEquals(slowResult, fastResult) : Objects.equal(slowResult, fastResult);
            Preconditions.checkArgument(areResultsEquals, test.generateExceptionMessage(slowResult, fastResult));
        }
    }

    private static boolean areArraysEquals(Object slowResult, Object fastResult) {
        Class clazz = slowResult.getClass().getComponentType();
        Object[] slowResultArr;
        Object[] fastResultArr;
        if (clazz.isPrimitive()) {
            slowResultArr = convertArray(slowResult);
            fastResultArr = convertArray(fastResult);
        } else {
            slowResultArr = (Object[]) slowResult;
            fastResultArr = (Object[]) fastResult;
        }
        return Arrays.equals(slowResultArr, fastResultArr);
    }

    private static Object[] convertArray(Object resultArray) {
        List arr = new ArrayList<>();
        int slowLength = Array.getLength(resultArray);
        for (int i = 0; i < slowLength; i++) {
            arr.add(Array.get(resultArray, i));
        }
        return arr.toArray();
    }
}
