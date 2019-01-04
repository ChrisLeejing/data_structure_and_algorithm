package com.jikeshijian.linkedlist06;

/**
 * SNode
 * simulate the node of the linked list.
 * @author lijing
 * @date 2019/1/3 9:53
 */
public class SNode<T> {

    private T element;
    private SNode next;

    public SNode(SNode next) {
        this.next = next;
    }

    public SNode(T element) {
        this.element = element;
    }

    public SNode() {
    }

    public SNode(T element, SNode next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SNode getNext() {
        return next;
    }

    public void setNext(SNode next) {
        this.next = next;
    }
}
