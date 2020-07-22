package com.jikeshijian.chris.test;

import com.jikeshijian.chris.sort1.Selection;

import java.util.Arrays;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/16 21:37
 */
public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = {8, 5, 2, 6, 9, 3, 1, 4, 0, 7};

        Selection.sort(arr);

        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(arr));

    }
}
