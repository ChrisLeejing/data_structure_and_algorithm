package com.jikeshijian.chris.list1;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> orderSymbolTable = new OrderSymbolTable<>();
        orderSymbolTable.put(3, "c");
        orderSymbolTable.put(4, "d");
        orderSymbolTable.put(1, "a");
        orderSymbolTable.put(2, "b");
        orderSymbolTable.put(5, "e");

        for (int i = 1; i <= 5; i++) {
            System.out.print(orderSymbolTable.get(i) + " ");
        }
        System.out.println();
        System.out.println("-------------");
        System.out.println(orderSymbolTable.size());
        orderSymbolTable.delete(3);
        System.out.println(orderSymbolTable.size());

    }

    private Node<Key, Value> head;
    private int N;

    private OrderSymbolTable() {
        this.head = new Node<>(null, null, null);
        this.N = 0;
    }

    private Value get(Key key) {
        Node<Key, Value> curr = head;
        while (curr != null) {
            curr = curr.next;
            if (curr.key.equals(key)) {
                return curr.value;
            }
        }
        return null;
    }

    private void put(Key key, Value value) {
        Node<Key, Value> pre = head;
        Node<Key, Value> curr = head.next;
        // eg: 1 -> 2 -> 3 -> 5     put 4   1 -> 2 -> 3 -> 4 -> 5
        while (curr != null && curr.key.compareTo(key) < 0) {
            pre = curr;
            curr = curr.next;
        }
        // here, not while loop, but if loop.
        if (curr != null && curr.key.compareTo(key) == 0) {
            curr.value = value;
            return;
        }
        // now, the curr == null or the curr.key > key.
        Node<Key, Value> newNode = new Node<>(key, value, curr);
        pre.next = newNode;
        N++;
    }

    private void delete(Key key) {
        Node<Key, Value> curr = head;
        while (curr != null) {
            if (curr.next.key.equals(key)) {
                curr.next = curr.next.next;
                N--;
                return;
            }
            curr = curr.next;
        }
    }

    private int size() {
        return N;
    }

    private class Node<Key, Value> {
        Key key;
        Value value;
        Node<Key, Value> next;

        Node(Key key, Value value, Node<Key, Value> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
