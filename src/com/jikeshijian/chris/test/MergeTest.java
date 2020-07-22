package com.jikeshijian.chris.test;

import com.jikeshijian.chris.sort1.Merge;

import java.util.Arrays;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/22 23:32
 */
public class MergeTest {
    public static void main(String[] args) {
        Integer[] arr = {5, 6, 7, 2, 8, 9};

        Merge.sort(arr);

        // [2, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(arr));
    }
}
