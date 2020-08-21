package com.jikeshijian.chris.list1;

import java.util.Iterator;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class Queue<T> implements Iterable<T> {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        // 4 -> 3 -> 2 -> 1
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    private Node head;
    private Node last;
    private int N;

    Queue() {
        this.head = new Node(null, null);
        this.last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(T t) {
        if (last == null) {
            last = new Node<>(t, null);
            head.next = last;
        } else {
            Node oldLast = last;
            last = new Node(t, null);
            oldLast.next = last;
        }
        N++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node old = head.next;
        head.next = old.next;
        N--;

        if (last == null) {
            return null;
        }
        return (T) old.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator(head);
    }

    class QueueIterator<T> implements Iterator<T> {
        private Node<T> head;

        public QueueIterator(Node<T> head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return head.next != null;
        }

        @Override
        public T next() {
            head = head.next;
            return head.item;
        }
    }

    class Node<T> {
        private T item;
        private Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

}
