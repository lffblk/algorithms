package com.sedgwick.algorithms.chapter1.section5;

public class FastUnionUnionFindTest extends UnionFindTest {
    @Override
    void init(int n) {
        uf = new FastUnionUnionFind(n);
    }
}