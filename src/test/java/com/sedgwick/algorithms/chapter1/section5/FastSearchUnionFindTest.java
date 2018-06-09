package com.sedgwick.algorithms.chapter1.section5;

public class FastSearchUnionFindTest extends UnionFindTest {
    @Override
    public void init(int n) {
        uf = new FastSearchUnionFind(n);
    }
}
