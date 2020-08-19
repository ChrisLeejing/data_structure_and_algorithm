package com.jikeshijian.chris.list1;

import java.util.Iterator;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class Stack<T> implements Iterable<T> {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // 4 -> 3 -> 2 -> 1
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        for (Integer integer : stack) {
            System.out.println(integer);
        }

        System.out.println("-------------");

        Integer first = stack.pop();
        System.out.println("pop first: " + first);
        System.out.println("the n of the stack: " + stack.N);

        Integer second = stack.pop();
        System.out.println("pop second: " + second);
        System.out.println("the n of the stack: " + stack.N);

        Integer third = stack.pop();
        System.out.println("pop third: " + third);
        System.out.println("the n of the stack: " + stack.N);

        Integer fourth = stack.pop();
        System.out.println("pop fourth: " + fourth);
        System.out.println("the n of the stack: " + stack.N);
    }

    private Node head;
    private int N;

    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        Node pop = head.next;
        head.next = pop.next;
        N--;
        return (T) pop.item;
    }

    public void push(T t) {
        Node old = head.next;
        Node<T> curr = new Node<>(t, old);
        head.next = curr;
        N++;
    }

    private class Node<T> {
        private T item;
        private Node next;

        public Node() {
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator {
        private Node node;

        public StackIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }

}
