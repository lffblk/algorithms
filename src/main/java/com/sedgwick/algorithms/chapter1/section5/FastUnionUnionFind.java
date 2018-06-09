package com.sedgwick.algorithms.chapter1.section5;

public class FastUnionUnionFind extends AbstractUnionFind {

    public FastUnionUnionFind(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        componentIds[qRoot] = pRoot;
        componentCount--;
    }

    @Override
    public int find(int p) {
        while (p != componentIds[p]) {
            p = componentIds[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
