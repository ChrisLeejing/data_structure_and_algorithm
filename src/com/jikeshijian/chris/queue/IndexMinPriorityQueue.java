package com.jikeshijian.chris.queue;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {
    /**
     * store the items of the Queue.
     */
    private T[] items;

    /**
     * store the index of the T[] items, pq makes the Queue sorted.
     */
    private int[] pq;

    /**
     * qp[pq[i]] = pq[qp[i]] = i
     */
    private int[] qp;

    /**
     * the number of pq.
     */
    private int N;

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity];
        this.qp = new int[capacity];
        this.N = 0;

        // set the default value -1 of the qp.
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    private boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private void exchange(int i, int j) {
        // exchange the index of pq.
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;

        // update the index of qp.
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public int delMin() {
        int minIndex = pq[1];
        exchange(1, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[minIndex] = null;
        N--;
        sink(1);

        return minIndex;
    }

    public void insert(int i, T t) {
        N++;
        items[i] = t;
        pq[N] = i;
        qp[i] = N;

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

    private void sink(int k) {
        while (2 * k <= N) {
            int minIndex = 2 * k;
            if (2 * k + 1 <= N && less(2 * k + 1, 2 * k)) {
                minIndex = 2 * k + 1;
            }
            if (less(k, minIndex)) {
                break;
            }

            exchange(k, minIndex);
            k = minIndex;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void changeItem(int i, T t) {
        items[i] = t;
        int k = qp[i];

        sink(k);
        swim(k);
    }

    public int minIndex() {
        return pq[1];
    }

    public void delete(int i) {
        int k = qp[i];

        exchange(k, N);
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[k] = null;

        N--;
        sink(k);
        swim(k);
    }
}
