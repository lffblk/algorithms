package com.sedgwick.algorithms.chapter3.section1;

import com.sedgwick.algorithms.chapter1.section3.collections.queue.LinkedListQueue;
import com.sedgwick.algorithms.chapter1.section3.collections.queue.Queue;
import com.sedgwick.algorithms.chapter3.OrderedSymbolTable;

public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public BinarySearchSymbolTable(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        if (currentSize == keys.length) {
            resize(keys.length * 2);
        }
        int i = rank(key);
        if (i < currentSize && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = currentSize; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        currentSize++;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < currentSize && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        int i = rank(key);

        for (int j = i; j < currentSize - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        if (currentSize > 0 && currentSize == keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[currentSize - 1];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        return keys[i - 1];
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        int lo = 0;
        int hi = currentSize - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int compareResult = key.compareTo(keys[mid]);
            if (compareResult < 0) {
                hi = mid - 1;
            }
            else if (compareResult > 0) {
                lo = mid + 1;
            }
            else return mid;
        }
        return lo;
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> keysQueue = new LinkedListQueue<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            keysQueue.enqueue(keys[i]);
        }
        if (contains(hi)) {
            keysQueue.enqueue(keys[rank(hi)]);
        }
        return keysQueue;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> keysQueue = new LinkedListQueue<>();
        for (int i = 0; i < currentSize; i++) {
            keysQueue.enqueue(keys[i]);
        }
        return keysQueue;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        Key[] tempKeys = (Key[]) new Comparable[newSize];
        Value[] tempValues = (Value[]) new Comparable[newSize];

        System.arraycopy(keys, 0, tempKeys, 0, currentSize);
        System.arraycopy(values, 0, tempValues, 0, currentSize);

        keys = tempKeys;
        values = tempValues;
    }
}
