package com.sedgwick.algorithms.chapter1.section5;

public class WeightedFastUnionUnionFind extends FastUnionUnionFind {

    private int[] sz;

    WeightedFastUnionUnionFind(int n) {
        super(n);
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (sz[pRoot] < sz[qRoot]) {
            componentIds[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            componentIds[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        componentCount--;
    }
}
