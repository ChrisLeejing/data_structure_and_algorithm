package com.jikeshijian.heima.sort1;

/**
 * This is description.
 * SelectSort:
 * Before: {4,6,8,7,9,2,10,1}
 * After: {1,2,4,5,7,8,9,10}
 * Time Complexity: O(n^2)
 *
 * @author Chris Lee
 * @date 2020/7/16 21:19
 */
public class SelectSort {

    public static void sort(Comparable[] comparables) {
        for (int i = 0; i < comparables.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < comparables.length; j++) {
                if (greater(comparables[minIndex], comparables[j])) {
                    minIndex = j;
                }
            }
            exchange(comparables, i, minIndex);
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
