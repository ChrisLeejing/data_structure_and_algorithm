package com.jikeshijian.chris.test;

import com.jikeshijian.chris.BinaryTree;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        tree.put(1, "a");
        tree.put(2, "b");
        tree.put(3, "c");
        System.out.println("the count after put: " + tree.size());

        System.out.println("the value of key(1): " + tree.get(1));
        System.out.println("the value of key(2): " + tree.get(2));
        System.out.println("the value of key(3): " + tree.get(3));

        tree.delete(3);
        System.out.println("the count after delete: " + tree.size());
        System.out.println("the value of key(1) after delete key(3): " + tree.get(1));
        System.out.println("the value of key(2) after delete key(3): " + tree.get(2));
        System.out.println("the value of key(3) after delete key(3): " + tree.get(3));

        /*
        the count after put: 3
        the value of key(1): a
        the value of key(2): b
        the value of key(3): c
        the count after delete: 2
        the value of key(1) after delete key(3): a
        the value of key(2) after delete key(3): b
        the value of key(3) after delete key(3): null
         */
    }
}
