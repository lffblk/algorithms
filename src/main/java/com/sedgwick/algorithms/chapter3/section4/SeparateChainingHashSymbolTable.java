package com.sedgwick.algorithms.chapter3.section4;

import com.google.common.collect.Lists;
import com.sedgwick.algorithms.chapter3.SymbolTable;
import com.sedgwick.algorithms.chapter3.section1.SequentalSearchSymbolTable;

import java.util.List;

public class SeparateChainingHashSymbolTable<Key, Value> implements SymbolTable<Key, Value> {

    private int currentSize;
    private int tableSize;
    private SequentalSearchSymbolTable<Key, Value>[] symbolTables;

    public SeparateChainingHashSymbolTable() {
        this(997);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashSymbolTable(int tableSize) {
        this.tableSize = tableSize;
        symbolTables = (SequentalSearchSymbolTable<Key, Value>[]) new SequentalSearchSymbolTable[tableSize];
        for (int i = 0; i < tableSize; i++) {
            symbolTables[i] = new SequentalSearchSymbolTable<>();
        }
    }

    @Override
    public void put(Key key, Value value) {
        if (currentSize >= tableSize / 2) {
            resize(tableSize * 2);
        }
        symbolTables[hash(key)].put(key, value);
        currentSize++;
    }

    @Override
    public Value get(Key key) {
        return symbolTables[hash(key)].get(key);
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keys = Lists.newLinkedList();
        for (SequentalSearchSymbolTable<Key, Value> subTable : symbolTables) {
            keys.addAll(Lists.newLinkedList(subTable.keys()));
        }
        return keys;
    }

    @Override
    public void delete(Key key) {
        symbolTables[hash(key)].delete(key);
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
        SequentalSearchSymbolTable<Key, Value>[] oldSymbolTables = symbolTables;
        symbolTables = (SequentalSearchSymbolTable<Key, Value>[]) new SequentalSearchSymbolTable[tableSize];
        for (int i = 0; i < tableSize; i++) {
            symbolTables[i] = new SequentalSearchSymbolTable<>();
        }

        for (SequentalSearchSymbolTable<Key, Value> oldSymbolTable : oldSymbolTables) {
            for (Key key : oldSymbolTable.keys()) {
                put(key, oldSymbolTable.get(key));
            }
        }
    }
}
