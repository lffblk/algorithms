package com.sedgwick.algorithms.chapter1.section3.collections;

public class LinkedListNode<Item> {
    private Item item;
    private LinkedListNode<Item> next;

    public LinkedListNode(Item item, LinkedListNode<Item> next) {
        this.item = item;
        this.next = next;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LinkedListNode<Item> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<Item> next) {
        this.next = next;
    }
}
