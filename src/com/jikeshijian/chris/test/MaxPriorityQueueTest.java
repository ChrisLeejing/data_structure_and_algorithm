package com.jikeshijian.chris.test;

import com.jikeshijian.chris.queue.MaxPriorityQueue;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        while (!queue.isEmpty()) {
            String max = queue.delMax();
            System.out.print(max + " ");
        }

        /*
        G F E D C B A
         */
    }
}
