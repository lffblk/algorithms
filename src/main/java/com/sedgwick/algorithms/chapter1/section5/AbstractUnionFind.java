package com.sedgwick.algorithms.chapter1.section5;

public abstract class AbstractUnionFind implements UnionFind {

    int componentIds[];
    int componentCount;

    AbstractUnionFind(int n) {
        componentCount = n;
        componentIds = new int[n];
        for (int i = 0; i < n; i++) {
            componentIds[i] = i;
        }
    }

    @Override
    public int count() {
        return componentCount;
    }
}
