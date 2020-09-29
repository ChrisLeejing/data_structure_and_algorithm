package com.jikeshijian.chris.test;

import com.jikeshijian.chris.queue.MinPriorityQueue;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class MinPriorityQueueTest {
    public static void main(String[] args) {
        MinPriorityQueue<String> queue = new MinPriorityQueue<>(10);
        queue.insert("B");
        queue.insert("C");
        queue.insert("A");
        queue.insert("F");
        queue.insert("G");
        queue.insert("E");
        queue.insert("D");
        queue.insert("H");

        while (!queue.isEmpty()) {
            String min = queue.delMin();
            System.out.print(min + " ");
        }

        /*
        A B C D E F G H
         */
    }
}
