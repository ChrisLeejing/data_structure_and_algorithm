package com.jikeshijian.chris.test;

import com.jikeshijian.chris.BinaryTree;
import com.jikeshijian.chris.list1.Queue;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        /*
        // Test 1: put(), get(), delete() method of BinaryTree.
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
        */
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

        /*
        // Test 2: test the min(), max() of BinaryTree.
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");
        String minKey = tree.min();
        System.out.println(minKey);

        String maxKey = tree.max();
        System.out.println(maxKey);
        */

        // Test 3: test the preErgodic(), midErgodic(), postErgodic(), layerErgodic(), maxDepth() of BinaryTree.
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");
        Queue<String> preErgodic = tree.preErgodic();
        System.out.print("BinaryTree preErgodic: ");
        for (String key : preErgodic) {
            System.out.print(key);
        }
        System.out.println();

        Queue<String> midErgodic = tree.midErgodic();
        System.out.print("BinaryTree midErgodic: ");
        for (String key : midErgodic) {
            System.out.print(key);
        }
        System.out.println();

        Queue<String> postErgodic = tree.postErgodic();
        System.out.print("BinaryTree postErgodic: ");
        for (String key : postErgodic) {
            System.out.print(key);
        }
        System.out.println();

        Queue<String> layerErgodic = tree.layerErgodic();
        System.out.print("BinaryTree layerErgodic: ");
        for (String key : layerErgodic) {
            System.out.print(key);
        }
        System.out.println();

        int maxDepth = tree.maxDepth();
        System.out.println("BinaryTree maxDepth: " + maxDepth);

        /*
        BinaryTree preErgodic: EBADCGFH
        BinaryTree midErgodic: ABCDEFGH
        BinaryTree postErgodic: ACDBFHGE
        BinaryTree layerErgodic: EBGADFHC
        BinaryTree maxDepth: 4
         */
    }
}
