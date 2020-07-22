package com.jikeshijian.chris.sort1;

/**
 * This is description.
 * Merge:
 * Time Complexity: O(nlogn)
 *
 * @author Chris Lee
 * @date 2020/7/22 22:53
 */
public class Merge {

    private static Comparable[] assist;

    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length - 1;

        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= hi) {
            if (less(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }
        }
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }

        while (p2 <= hi) {
            assist[i++] = a[p2++];
        }

        for (int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }
    }
}
