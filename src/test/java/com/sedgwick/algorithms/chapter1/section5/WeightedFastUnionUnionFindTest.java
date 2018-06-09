package com.sedgwick.algorithms.chapter1.section5;

import org.junit.Test;

public class WeightedFastUnionUnionFindTest extends UnionFindTest {

    @Override
    void init(int n) {
        uf = new WeightedFastUnionUnionFind(n);
    }

    @Test
    public void testLargeInput() {
        doTest("largeUF.txt", 6);
    }
}