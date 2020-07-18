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
        Integer[] arr = {4, 3, 2, 10, 12, 1, 5, 6};

        Insertion.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
