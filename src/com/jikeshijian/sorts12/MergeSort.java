package com.jikeshijian.sorts12;

import java.util.Arrays;

/**
 * MergeSort: O(nlogn)
 *
 * @author Chris
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 2, 4, 7, 6, 1, 9, 8};
        int n = a.length;

        mergeSort(a, n);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        // q: the split point.
        int q = (p + r) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // merge the arrays.
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // move the leftover value to the tmp[].
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // move the tmp[] to a[].
        for (i = 0; i <= r - p; i++) {
            a[p + i] = tmp[i];
        }
    }
}
