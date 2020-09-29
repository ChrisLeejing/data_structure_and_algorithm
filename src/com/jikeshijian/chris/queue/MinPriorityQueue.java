package com.jikeshijian.chris.queue;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity];
        this.N = 0;
    }

    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    public void exchange(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                exchange(k, k / 2);
            }
            k = k / 2;
        }
    }

    public T delMin() {
        T min = items[1];
        exchange(1, N);
        items[N] = null;
        N--;
        sink(1);
        return min;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int min = 2 * k;
            if (2 * k + 1 <= N && less(2 * k + 1, 2 * k)) {
                min = 2 * k + 1;
            }
            if (less(k, min)) {
                break;
            }

            exchange(k, min);
            k = min;
        }
    }
}
