package com.jikeshijian.linkedlist06;

import java.util.Scanner;

/**
 * LRUBaseLinkedList
 * LRU（Least Recently Used）
 * 如何基于链表实现 LRU 缓存淘汰算法？
 * 我的思路是这样的：我们维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 * 	    如果此时缓存未满，则将此结点直接插入到链表的头部；
 * 	    如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 *  现在我们来看下 m 缓存访问的时间复杂度是多少。因为不管缓存有没有满，我们都需要遍历一遍链表，所以这种基于链表的实现思路，缓存访问的时间复杂度为 O(n)。
 * 实际上，我们可以继续优化这个实现思路，比如引入散列表（Hash table）来记录每个数据的位置，将缓存访问的时间复杂度降到 O(1)。因为要涉及我们还没有讲到的数据结构，所以这个优化方案，我现在就不详细说了，等讲到散列表的时候，我会再拿出来讲。
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
