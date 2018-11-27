package com.jikeshijian.sorts12;

import java.util.Arrays;

/**
 * QuickSort: O(nlogn)
 *
 * @author Chris
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 9, 1, 3, 5, 7};
        int n = a.length;

        quickSort(a, n);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        // find the index of pivot.
        // int q = partition(a, p, r);
        int q = partition2(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    /**
     * partition: set the default pivot is the last number.
     * @param a: the array.
     * @param p: the start index.
     * @param r: the end index.
     */
    private static int partition(int[] a, int p, int r) {
        int i = p;
        int pivot = a[r];
        // put the larger number front, put the smaller number behind.
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }

        // exchange a[i] and a[r].
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println(i);
        return i;
    }

    /**
     * partition2: set the default pivot is the first number.
     * @param a: the array.
     * @param p: the start index.
     * @param r: the end index.
     */
    private static int partition2(int[] a, int p, int r) {
        int pivot = a[p];
        int left = p+1;
        int right = r;
        boolean flag= false;
        while (!flag) {
            while (left <= right && a[left] <= pivot) {
                left++;
            }
            while (left <= right && a[right] >= pivot) {
                right--;
            }
            if (left > right) {
                flag = true;
            } else {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
            }
        }

        // exchange a[p] and a[right].
        int tmp = a[p];
        a[p] = a[right];
        a[right] = tmp;

        // the right is the index of pivot.
        return right;
    }
}
