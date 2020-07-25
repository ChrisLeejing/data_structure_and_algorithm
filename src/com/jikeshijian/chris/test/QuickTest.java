package com.jikeshijian.chris.test;

import com.jikeshijian.chris.sort1.Quick;

import java.util.Arrays;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/25 23:05
 */
public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 8};

        Quick.sort(arr);

        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(arr));
    }
}
