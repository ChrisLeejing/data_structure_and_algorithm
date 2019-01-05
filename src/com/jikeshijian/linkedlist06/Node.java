package com.jikeshijian.linkedlist06;

/**
 * @author lijing
 * @date 2019/1/5 9:30
 */
public class Node {
    private int data;
    private Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
