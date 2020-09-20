package com.jikeshijian.chris.test;

import com.jikeshijian.chris.heap.Heap;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class HeapTest {
    public static void main(String[] args) {
        String element;

        Heap<String> heap = new Heap<>(7);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            element = heap.delMax();
            if (element != null) {
                System.out.print(element + " ");
            }
        }

        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

        for (int i = 0; i < size; i++) {
            element = heap.delMax();
            if (element != null) {
                System.out.print(element + " ");
            }
        }
    }
}
