package com.jikeshijian.heima.sort1;

/**
 * This is description.
 * Insertion:
 * Time Complexity: O(n^2)
 *
 * @author Chris Lee
 * @date 2020/7/16 21:42
 */
public class Insertion {
    public static void sort(Comparable[] comparables) {
        for (int i = 1; i < comparables.length; i++) {
            for (int j = i; j > 0; j--) {
                if (greater(comparables[j - 1], comparables[j])) {
                    exchange(comparables, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static boolean greater(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0;
    }

    public static void exchange(Comparable[] comparables, int i, int j) {
        Comparable tmp = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = tmp;
    }
}