package com.sedgwick.algorithms.chapter3.section3;

import com.sedgwick.algorithms.chapter3.section2.BinarySearchTree;

public class RedBlackBinarySearchTree <Key extends Comparable<Key>, Value> extends BinarySearchTree<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    @Override
    public void put(Key key, Value value) {
        super.put(key, value);
        root.setColor(BLACK);
    }

    @Override
    protected Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1, RED);
        }
        int compareResult = key.compareTo(node.getKey());
        if (compareResult < 0) {
            node.setLeft(put(node.getLeft(), key, value));
        }
        else if (compareResult > 0) {
            node.setRight(put(node.getRight(), key, value));
        }
        else {
            node.setValue(value);
        }
        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }
        node.setSubNodesCount(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    @Override
    public void deleteMin() {
        if (!isRed(root.getLeft()) && !isRed(root.getRight())) {
            root.setColor(RED);
        }
        root = deleteMin(root);
        if (!isEmpty()) {
            root.setColor(BLACK);
        }
    }

    @Override
    public void deleteMax() {
        if (!isRed(root.getLeft()) && !isRed(root.getRight())) {
            root.setColor(RED);
        }
        root = deleteMax(root);
        if (!isEmpty()) {
            root.setColor(BLACK);
        }
     }

    private boolean isRed(Node node) {
        return node != null && node.getColor() == RED;
    }

    private Node rotateLeft(Node node) {
        Node x = node.getRight();
        node.setRight(x.getLeft());
        x.setLeft(node);
        x.setColor(node.getColor());
        node.setColor(RED);
        x.setSubNodesCount(node.getSubNodesCount());
        node.setSubNodesCount(1 + size(node.getLeft()) + size(node.getRight()));
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.getLeft();
        node.setLeft(x.getRight());
        x.setRight(node);
        x.setColor(node.getColor());
        node.setColor(RED);
        x.setSubNodesCount(node.getSubNodesCount());
        node.setSubNodesCount(1 + size(node.getLeft()) + size(node.getRight()));
        return x;
    }

    private void flipColors(Node node) {
        node.setColor(RED);
        node.getLeft().setColor(BLACK);
        node.getRight().setColor(BLACK);
    }

    private Node moveRedLeft(Node node) {
        flipColors(node);
        if (isRed(node.getRight().getLeft())) {
            node.setRight(rotateRight(node.getRight()));
            node = rotateLeft(node);
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.getLeft() == null) {
            return null;
        }
        if (!isRed(node.getLeft()) && !isRed(node.getLeft().getLeft())) {
            node = moveRedLeft(node);
        }
        node.setLeft(deleteMin(node.getLeft()));
        return balance(node);
    }

    private Node balance(Node node) {
        if (isRed(node.getRight())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }
        node.setSubNodesCount(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    private Node moveRedRight(Node node) {
        flipColors(node);
        if (!isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        return node;
    }

    private Node deleteMax(Node node) {
        if (isRed(node.getLeft())) {
            node = rotateRight(node);
        }
        if (node.getRight() == null) {
            return null;
        }
        if (!isRed(node.getRight()) && !isRed(node.getRight().getLeft())) {
            node = moveRedRight(node);
        }
        node.setRight(deleteMax(node.getRight()));
        return balance(node);
    }

    private Node delete(Node node, Key key) {
        if (key.compareTo(node.getKey()) < 0) {
            if (!isRed(node.getLeft()) && !isRed(node.getLeft().getLeft())) {
                node = moveRedLeft(node);
            }
            node.setLeft(delete(node.getLeft(), key));
        }
        else {
            if (isRed(node.getLeft())) {
                node = rotateRight(node);
            }
            if (key.compareTo(node.getKey()) == 0 && node.getRight() == null) {
                return null;
            }
            if (!isRed(node.getRight()) && !isRed(node.getRight().getLeft())) {
                node = moveRedRight(node);
            }
            if (key.compareTo(node.getKey()) == 0) {
                node.setValue(get(min(node.getRight()).getKey(), node.getRight()));
                node.setKey(min(node.getRight()).getKey());
                node.setRight(deleteMin(node.getRight()));
            }
            else {
                node.setRight(delete(node.getRight(), key));
            }
        }
        return balance(node);
    }
}
