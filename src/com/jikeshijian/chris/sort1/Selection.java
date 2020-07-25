package com.jikeshijian.chris.sort1;

/**
 * This is description.
 * Selection:
 * Time Complexity: O(n^2)
 *
 * @author Chris Lee
 * @date 2020/7/16 21:19
 */
public class Selection {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            exchange(a, i, minIndex);
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
