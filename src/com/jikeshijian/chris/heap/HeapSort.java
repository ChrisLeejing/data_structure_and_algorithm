package com.jikeshijian.chris.heap;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class HeapSort {
    public static void sort(Comparable[] source) {
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);

        // to tag the max index of heap's unsorted element.
        int maxIndex = heap.length - 1;
        while (maxIndex != 1) {
            exchange(heap, 1, maxIndex);
            maxIndex--;
            sink(heap, 1, maxIndex);
        }

        // copy the heap value to the original source.
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    /**
     * To make the heap sorted:
     * step 1: create a new array, copy the 0 ~ length-1 to 1 ~ length(new array)
     * step 2: scan the length/2 to index 1, make every scanned value sink.
     *
     * @param source
     * @param heap
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        System.arraycopy(source, 0, heap, 1, source.length);
        for (int i = heap.length / 2; i > 0; i--) {
            // the number of heap is length-1.(the 0 index element is omitted)
            sink(heap, i, heap.length - 1);
        }
    }

    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private static void exchange(Comparable[] heap, int i, int j) {
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private static void sink(Comparable[] heap, int target, int range) {
        while (2 * target <= range) {
            int max;
            if (2 * target + 1 <= range) {
                if (less(heap, 2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                } else {
                    max = 2 * target;
                }
            } else {
                max = 2 * target;
            }

            // if items[target] >= items[max], stop sink.
            if (!less(heap, target, max)) {
                break;
            }
            exchange(heap, target, max);

            target = max;
        }
    }

}
