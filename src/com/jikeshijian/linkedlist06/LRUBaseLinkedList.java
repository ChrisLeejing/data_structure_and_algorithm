package com.jikeshijian.linkedlist06;

import java.util.Scanner;

/**
 * LRUBaseLinkedList
 * LRU（Least Recently Used）
 * @author lijing
 * @date 2019/1/3 9:57
 */
public class LRUBaseLinkedList<T> {

    /**
     * the default capacity is 10.
     */
    private static Integer DEFAULT_CAPACITY = 10;

    /**
     * the head node.
     */
    private SNode<T> headNode;

    /**
     * the length of the linked list.
     */
    private Integer length;

    /**
     * the capacity of the linked list.
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * add a data.
     * @param data
     */
    private void add(T data) {
        SNode preNode = findPreNode(data);

        if (preNode != null) {
            deleteCurrentNodeByPreNode(preNode);
            insertNodeAtBegin(data);
        } else {
            if (length >= capacity) {
                deleteNodeAtEnd();
            }
            insertNodeAtBegin(data);
        }
    }

    private void printAll() {
        SNode node = headNode;

        while (node.getNext() != null) {
            System.out.print(node.getElement() + ", ");
            node = node.getNext();
        }
        System.out.println();
    }
    /**
     * find the pre-node of the current node with the same data.
     * @param data the current node.
     * @return the pre-node.
     */
    private SNode findPreNode(T data) {
        SNode node = headNode;

        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }

            node = node.getNext();
        }

        return null;
    }

    /**
     * delete the current node through the pre-node.
     * @param preNode pre-node.
     */
    private void deleteCurrentNodeByPreNode(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * insert a node at the begin of the linked list.
     *
     * @param data a node.
     */
    private void insertNodeAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * delete the node at the end of the linked list.
     */
    private void deleteNodeAtEnd() {
        SNode node = headNode;

        // when the node is null, return directly.
        while (node.getNext() == null) {
            return;
        }

        // find node = the The penultimate node(the node before the last node).
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }

        SNode lastNode = node.getNext();
        node.setNext(null);
        lastNode = null;
        length--;
    }

    public static void main(String[] args){
        LRUBaseLinkedList<Object> list = new LRUBaseLinkedList<>();
        System.out.println("Please input a number: ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            list.add(scanner.nextInt());
            list.printAll();
        }
    }

}
