package com.jikeshijian.sorts11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * 冒泡排序(bubbleSort): O(n^2), 插入排序(insertionSort): O(n^2), 选择排序(selectionSort): O(n^2)
 *
 * @author Chris
 */
public class Sorts {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 7, 9, 6, 4, 8};
        int length = arr.length;
        // bubbleSort(arr, length);
        // insertionSort(arr, length);
        // selectionSort(arr, length);
        // Arrays.toString(arr): 源码中使用到了StringBuilder的拼接功能.
        System.out.println(Arrays.toString(arr));

    }

    /**
     * bubbleSort: a: the int array, n: the length of array.
     * 思路: 冒泡排序只会比较相邻的两个数的大小, 大小不合适, 则交换位置.
     * 每一次比较排好一个数, 经过n次, 排好整个数列.
     * 情况一:               情况二:
     * 3, 1, 5, 2, 4        2, 1, 3, 4, 5
     * 1, 3, 5, 2, 4        1, 2, 3, 4, 5
     * 1, 3, 2, 5, 4        设置flag=false;就非常有用, 不用再循环了, 可以跳出循环.
     * 1, 3, 2, 4, 5
     * 1, 2, 3, 4, 5
     * 优化:
     * 1. if(n <= 1) {return;}: 为了逻辑严谨和代码规范.
     * 2. 不要使用int value1 = a[i];和int value2 = a[j];会造成value1与value2的值交换后并不会改变数组的大小顺序.
     * 3. if (a[j] > a[j + 1]) {...}: 表示从小到大; if (a[j] < a[j + 1]) {...}: 表示从大到小;
     * 4. 通过设置退出标志位flag, 可以提高效率.
     * 5. j < n - i - 1; 1 bubble, 1 number is sorted, i bubbles, i numbers are sorted,
     *      so, the last i numbers are not need to be compared with.
     * @param a: the array to be sorted.
     * @param n: the length of the array.
     */
    private static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 设置退出标志位.
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 有交换, 标志位为true.
                    flag = true;
                }
            }
            // 没有交换数据时, 提前退出.
            if (!flag) {
                break;
            }
        }
    }

    /**
     * insertionSort: value from array[1] to array[n - 1], every time, compare the current value with the values before,
     * if the front number is larger, move it 1 bit backward, or break the loop(the front number is smaller).
     * then put the current value in the larger position.
     * (remark: because the loop judgement j--, the larger position should plus 1)
     * eg:
     * 3, 1, 5, 2, 4
     * 1, 3, 5, 2, 4    put 1 in the a[0] position.
     * 1, 3, 5, 2, 4    break the inner loop.
     * 1, 2, 3, 5, 4    put 2 between 1 and 3.
     * 1, 2, 3, 4, 5    put 4 between 3 and 5.
     * 1, 2, 3, 4, 5    the array is ok(the loop is over, the array is sorted ok.)
     * int value = a[i]; a[j] > value; a[j + 1] = value; because, each move(a[j + 1] = a[j];), the a[i] is different.
     * @param a: the array to be sorted.
     * @param n: the length of the array.
     */
    private static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            /*
                put the current value into right position. now, a[j] is less than the value;
                because the loop judgement j--, the larger position should plus 1.
             */
            a[j + 1] = value;

        }
    }

    /**
     * sectionSort: each loop, selection the index of the minimum number in the remaining values
     * and exchange the value.
     * @param a: the array to be sorted.
     * @param n: the length of the array.
     */
    private static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            // find the minValue, exchange the value of minValueIndex and i.
            int tmp = a[minValueIndex];
            a[minValueIndex] = a[i];
            a[i] = tmp;
        }
    }


}
