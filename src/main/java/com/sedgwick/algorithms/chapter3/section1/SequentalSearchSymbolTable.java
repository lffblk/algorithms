package com.sedgwick.algorithms.chapter3.section1;

import com.sedgwick.algorithms.chapter3.SymbolTable;

import java.util.Iterator;

public class SequentalSearchSymbolTable<Key, Value> implements SymbolTable<Key, Value> {

    private Node first;
    private int currentSize = 0;

    @Override
    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        currentSize++;
    }

    @Override
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
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
        return new NodeIterable();
    }

    @Override
    public void delete(Key key) {
        if (key.equals(first.key)) {
            first = first.next;
            currentSize--;
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.next.key)) {
                x.next = x.next.next;
                currentSize--;
                return;
            }
        }
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private class NodeIterable implements Iterable<Key> {
        Node currentNode = first;

        @Override
        public Iterator<Key> iterator() {
            return new Iterator<Key>() {
                @Override
                public boolean hasNext() {
                    return currentNode != null;
                }

                @Override
                public Key next() {
                    Key currentKey = currentNode.key;
                    currentNode = currentNode.next;
                    return currentKey;
                }
            };
        }
    }
}
