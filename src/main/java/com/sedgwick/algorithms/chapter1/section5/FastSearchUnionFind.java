package com.sedgwick.algorithms.chapter1.section5;

public class FastSearchUnionFind extends AbstractUnionFind {

    public FastSearchUnionFind(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        int qComponentId = find(q);
        int pComponentId = find(p);
        if (pComponentId == qComponentId) {
            return;
        }

        for (int i = 0; i < componentIds.length; i++) {
            if (componentIds[i] == qComponentId) {
                componentIds[i] = pComponentId;
            }
        }
        componentCount--;
    }

    @Override
    public int find(int p) {
        return componentIds[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
