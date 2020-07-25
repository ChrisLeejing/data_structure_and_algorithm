package com.jikeshijian.chris.sort1;

/**
 * This is description.
 * Shell:
 * Time complexity: O(nlogn)
 *
 * @author Chris Lee
 * @date 2020/7/20 23:30
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 2) {
            h = h * 2 + 1;
        }

        while (h >= 1) {
            // analogy: Insert Sort.
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(a[j - h], a[j])) {
                        exchange(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }

            h = h / 2;
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
