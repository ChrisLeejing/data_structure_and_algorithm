package com.jikeshijian.chris.sort1;

/**
 * This is description.
 * Insertion:
 * Time Complexity: O(n^2)
 *
 * @author Chris Lee
 * @date 2020/7/16 21:42
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (greater(a[j - 1], a[j])) {
                    exchange(a, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
