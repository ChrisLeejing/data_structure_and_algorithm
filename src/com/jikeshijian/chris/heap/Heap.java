package com.jikeshijian.chris.heap;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class Heap<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void exchange(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    public void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                exchange(k / 2, k);
            }
            // because, the initial heap is sorted.
            k = k / 2;
        }
    }

    public T delMax() {
        T max = items[1];

        exchange(1, N);
        items[N] = null;
        N--;

        sink(1);
        return max;
    }

    public void sink(int k) {
        while (2 * k <= N) {
            int max;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }

            // if items[k] >= items[max], stop sink.
            if (!less(k, max)) {
                break;
            }
            exchange(k, max);

            k = max;
        }
    }

}
