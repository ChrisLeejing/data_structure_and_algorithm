package com.jikeshijian.linkedlist06;

/**
 * SinglyLinkedList: insert, delete, find...
 * the value is int.
 *
 * @author lijing
 * @date 2019/1/5 9:40
 */
public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (head != null && p.getData() != value) {
            p = p.getNext();
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.getNext();
            pos++;
        }

        return p;
    }

    /**
     * Insert the node to the head.
     *
     * @param value the value of node.
     */
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    private void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void insertToTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            newNode.setNext(node.getNext());
            node.setNext(newNode);
        }

    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        newNode.setNext(p.getNext());
        p.setNext(newNode);
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        if (q == null) {
            return;
        }

        while (q != null && q.getNext() != p) {
            q = q.getNext();
        }

        newNode.setNext(q.getNext());
        q.setNext(newNode);
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }

        if (head == p) {
            head = head.getNext();
            return;
        }

        Node q = head;
        while (q != null && q.getNext() != p) {
            q = q.getNext();
        }

        if (q == null) {
            return;
        }

        q.setNext(q.getNext().getNext());
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }
        Node p = head;
        Node q = null;
        while (p != null && p.getData() != value) {
            q = p;
            p = p.getNext();
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.getNext();
        } else {
            q.setNext(q.getNext().getNext());
        }

    }

    public boolean palindrome(){
        /*
            如何判断一个字符串是否是回文字符串的问题，我想你应该听过，
            我们今天的思题目就是基于这个问题的改造版本。如果字符串是通过单链表来存储的，那该如何来判断是一个回文串呢？
            你有什么好的解决思路呢？相应的时间空间复杂度又是多少呢？
            参考解答: 【LeetCode刷题笔记】链表与快慢指针: https://zhuanlan.zhihu.com/p/38521018
         */
        // TODO
        return true;
    }
    public static void main(String[] args){

    }

}
