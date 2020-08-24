package com.jikeshijian.chris.list1;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class SymbolTable<Key, Value> {
    public static void main(String[] args) {
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();
        symbolTable.put(1, "a");
        symbolTable.put(2, "b");
        symbolTable.put(3, "c");
        symbolTable.put(5, "e");

        System.out.println(symbolTable.size());
        symbolTable.delete(3);
        System.out.println(symbolTable.size());
        for (int i = 1; i <= 5; i++) {
            System.out.print(symbolTable.get(i) + " ");
        }
        System.out.println();
        System.out.println("-------------");
        symbolTable.put(4, "d");
        System.out.println(symbolTable.size());

        for (int i = 1; i <= 5; i++) {
            System.out.print(symbolTable.get(i) + " ");
        }
    }

    private Node<Key, Value> head;
    private int N;

    private SymbolTable() {
        this.head = new Node<>(null, null, null);
        this.N = 0;
    }

    private Value get(Key key) {
        Node<Key, Value> curr = head;
        // the key exists, return the value.
        while (curr.next != null) {
            if (curr.next.key.equals(key)) {
                return curr.next.value;
            }
            curr = curr.next;
        }
        // the key does not exist, return null.
        return null;
    }

    private void put(Key key, Value value) {
        // the key exists, replace the value.
        Node<Key, Value> curr = head;
        while (curr.next != null) {
            if (curr.next.key.equals(key)) {
                curr.next.value = value;
                return;
            }
            curr = curr.next;
        }

        // the key does not exists, add the Node(key, value).
        Node<Key, Value> newNode = new Node<>(key, value, null);
        curr.next = newNode;
        N++;
    }

    private void delete(Key key) {
        Node<Key, Value> curr = head;
        while (curr.next != null) {
            if (curr.next.key.equals(key)) {
                curr.next = curr.next.next;
                N--;
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
