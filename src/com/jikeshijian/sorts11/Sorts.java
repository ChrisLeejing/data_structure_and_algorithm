package com.jikeshijian.sorts11;

import java.util.Arrays;

/**
 * 冒泡排序(bubbleSort), 插入排序(insertionSort), 选择排序(selectionSort)
 *
 * @author Chris
 */
public class Sorts {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        int length = arr.length;
        bubbleSort(arr, length);
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
     *
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
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
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

}
