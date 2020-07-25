package com.jikeshijian.chris.sort1;

/**
 * This is description.
 * Quick:
 * Time Complexity: O(nlogn)
 *
 * @author Chris Lee
 * @date 2020/7/25 22:40
 */
public class Quick {
    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length -1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int partition = partition(a, lo, hi);

        sort(a, lo, partition -1);
        sort(a, partition + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int left = lo;
        int right = hi + 1;

        while (true) {
            while (less(v, a[--right])) {
                if (right == lo) {
                    break;
                }
            }

            while (less(a[++left], v)) {
                if (left == hi) {
                    break;
                }
            }

            if (left >= right) {
                break;
            } else {
                exchange(a, left, right);
            }
        }

        exchange(a, lo, right);
        return right;
    }

    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
