package com.jikeshijian.chris.test;

import com.jikeshijian.chris.sort1.Insertion;

import java.util.Arrays;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/16 21:58
 */
public class InsertionTest {
    public static void main(String[] args) {
        Integer[] arr = {6, 5, 3, 1, 8, 7, 2, 4};

        Insertion.sort(arr);

        // [1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println(Arrays.toString(arr));
    }
}
