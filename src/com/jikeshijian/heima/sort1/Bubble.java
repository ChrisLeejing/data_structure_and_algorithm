package com.jikeshijian.heima.sort1;

/**
 * This is description.
 * Bubble:
 * Time Complexity：O(n^2)
 *
 * @author Chris Lee
 * @date 2020/7/5 19:55
 */
public class Bubble {

    public static void sort(Comparable[] comparables) {
        for (int i = comparables.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(comparables[j], comparables[j + 1])) {
                    exchange(comparables, j, j + 1);
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
