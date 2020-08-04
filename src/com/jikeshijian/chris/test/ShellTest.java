package com.jikeshijian.chris.test;

import com.jikeshijian.chris.sort1.Shell;

import java.util.Arrays;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/20 23:42
 */
public class ShellTest {

    public static void main(String[] args) {
        Integer[] arr = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};

        Shell.sort(arr);

        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(arr));

    }
}
