package com.sedgwick.algorithms.chapter3.section4;

import com.google.common.collect.Lists;
import com.sedgwick.algorithms.chapter3.SymbolTable;

import java.util.List;

public class LinearProbingHashSymbolTable<Key, Value> implements SymbolTable<Key, Value> {

    private int currentSize;
    private int tableSize = 16;
    private Key[] keys;
    private Value[] values;

    @SuppressWarnings("unchecked")
    public LinearProbingHashSymbolTable() {
        this.keys = (Key[]) new Object[tableSize];
        this.values = (Value[]) new Object[tableSize];
    }

    @SuppressWarnings("unchecked")
    public LinearProbingHashSymbolTable(int tableSize) {
        this.tableSize = tableSize;
        this.keys = (Key[]) new Object[tableSize];
        this.values = (Value[]) new Object[tableSize];
    }

    @Override
    public void put(Key key, Value value) {
        if (currentSize >= tableSize / 2) {
            resize(tableSize * 2);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % tableSize) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        currentSize++;
    }

    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % tableSize) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keysToReturn = Lists.newArrayList();
        for (Key key : keys) {
            if (key != null) {
                keysToReturn.add(key);
            }
        }
        return keysToReturn;
    }

    @Override
    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % tableSize;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % tableSize;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            currentSize--;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % tableSize;
        }
        currentSize--;
        if (currentSize > 0 && currentSize == tableSize / 8) {
            resize(tableSize / 2);
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % tableSize;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        tableSize = newSize;
        Key[] oldKeys = keys;
        Value[] oldValues = values;

        keys = (Key[]) new Object[tableSize];
        values = (Value[]) new Object[tableSize];

        for (int i = 0; i < oldKeys.length; i++) {
            if (oldKeys[i] != null) {
                put(oldKeys[i], oldValues[i]);
            }
        }
    }
}
