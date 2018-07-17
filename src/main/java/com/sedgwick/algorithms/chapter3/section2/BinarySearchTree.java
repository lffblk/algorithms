package com.sedgwick.algorithms.chapter3.section2;

import com.sedgwick.algorithms.chapter1.section3.collections.queue.LinkedListQueue;
import com.sedgwick.algorithms.chapter1.section3.collections.queue.Queue;
import com.sedgwick.algorithms.chapter3.OrderedSymbolTable;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {

    protected Node root;

    @Override
    public Key min() {
        return min(root).key;
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    @Override
    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return node.getKey();
    }

    @Override
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) {
            return null;
        }
        return node.getKey();
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    @Override
    public Key select(int k) {
        return select(root, k).key;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedListQueue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    @Override
    public void put(Key key, Value value) {
        this.root = put(root, key, value);
    }

    @Override
    public Value get(Key key) {
        return get(key, root);
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    protected Value get(Key key, Node node) {
        if (node == null) {
            return null;
        }
        int compareResult = node.getKey().compareTo(key);
        if (compareResult > 0) {
            return get(key, node.getLeft());
        }
        else if (compareResult < 0) {
            return get(key, node.getRight());
        }
        else {
            return node.getValue();
        }
    }

    protected Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int compareResult = node.getKey().compareTo(key);
        if (compareResult > 0) {
            node.setLeft(put(node.getLeft(), key, value));
        }
        else if (compareResult < 0) {
            node.setRight(put(node.getRight(), key, value));
        }
        else {
            node.setValue(value);
        }
        node.setSubNodesCount(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    protected int size(Node node) {
        if (node == null) {
            return 0;
        }
        else return node.getSubNodesCount();
    }

    protected class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int subNodesCount;
        private boolean color;

        Node(Key key, Value value, int subNodesCount) {
            this.key = key;
            this.value = value;
            this.subNodesCount = subNodesCount;
        }

        public Node(Key key, Value value, int subNodesCount, boolean color) {
            this.key = key;
            this.value = value;
            this.subNodesCount = subNodesCount;
            this.color = color;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getSubNodesCount() {
            return subNodesCount;
        }

        public void setSubNodesCount(int subNodesCount) {
            this.subNodesCount = subNodesCount;
        }

        public boolean getColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }

    protected Node min(Node node) {
        return node.getLeft() == null ? node : min(node.getLeft());
    }

    private Node max(Node node) {
        return node.getRight() == null ? node : max(node.getRight());
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.getKey());
        if (compareResult == 0) {
            return node;
        }
        else if (compareResult < 0) {
            return floor(node.getLeft(), key);
        }
        Node temp = floor(node.getRight(), key);
        if (temp != null) {
            return temp;
        }
        else {
            return node;
        }
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.getKey());
        if (compareResult == 0) {
            return node;
        }
        else if (compareResult > 0) {
            return ceiling(node.getRight(), key);
        }
        Node temp = ceiling(node.getLeft(), key);
        if (temp != null) {
            return temp;
        }
        else {
            return node;
        }
    }

    private Node select(Node node, int k) {
        if (node == null) {
             return null;
        }
        int leftSize = size(node.getLeft());
        if (leftSize > k) {
            return select(node.getLeft(), k);
        }
        else if (leftSize > k) {
            return select(node.getRight(), k - leftSize - 1);
        }
        else {
            return node;
        }
    }

    private int rank(Key key, Node node) {
        if (node == null) {
            return 0;
        }
        int compareResult = key.compareTo(node.getKey());
        if (compareResult < 0) {
            return rank(key, node.getLeft());
        }
        else if (compareResult > 0) {
            return 1 + size(node.getLeft()) + rank(key, node.getRight());
        }
        else {
            return size(node.getLeft());
        }
    }

    private Node deleteMin(Node node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(deleteMin(node.getLeft()));
        node.setSubNodesCount(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    private Node deleteMax(Node node) {
        if (node.getRight() == null) {
            return node.getLeft();
        }
        node.setRight(deleteMax(node.getRight()));
        node.setSubNodesCount(size(node.getRight()) + size(node.getLeft()) + 1);
        return node;
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.getKey());
        if (compareResult < 0) {
            node.setLeft(delete(node.getLeft(), key));
        }
        else if (compareResult > 0) {
            node.setRight(delete(node.getRight(), key));
        }
        else {
            if (node.getRight() == null) {
                return node.getLeft();
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }
            Node temp = node;
            node = min(temp.getRight());
            node.setRight(deleteMin(temp.getRight()));
            node.setLeft(temp.getLeft());
        }
        node.setSubNodesCount(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
        if (node == null) {
            return;
        }
        int cmpLo = lo.compareTo(node.getKey());
        int cmpHi = hi.compareTo(node.getKey());
        if (cmpLo < 0) {
            keys(node.getLeft(), queue, lo, hi);
        }
        if (cmpLo <= 0 && cmpHi >= 0) {
            queue.enqueue(node.getKey());
        }
        if (cmpHi > 0) {
            keys(node.getRight(), queue, lo, hi);
        }
    }
}
