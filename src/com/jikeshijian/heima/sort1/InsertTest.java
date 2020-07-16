package com.jikeshijian.heima.sort1;

import java.util.Arrays;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/16 21:58
 */
public class InsertTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 10, 12, 1, 5, 6};

        Insert.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
