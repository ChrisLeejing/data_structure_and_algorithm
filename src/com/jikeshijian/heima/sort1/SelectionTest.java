package com.jikeshijian.heima.sort1;

import java.util.Arrays;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/16 21:37
 */
public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 6, 8, 7, 9, 2, 10, 1};

        Selection.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
