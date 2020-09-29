package com.jikeshijian.chris.queue;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity];
        this.N = 0;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void exchange(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public T delMax() {
        T max = items[1];
        exchange(1, N);
        items[N] = null;
        N--;
        sink(1);

        return max;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                exchange(k / 2, k);
            }
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int max = 2 * k;
            if (2 * k + 1 <= N && less(2 * k, 2 * k + 1)) {
                max = 2 * k + 1;
            }
            if (!less(k, max)) {
                break;
            }

            exchange(k, max);
            k = max;

        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

}
