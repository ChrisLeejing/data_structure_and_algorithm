package com.jikeshijian.chris.test;

import com.jikeshijian.chris.sort1.Bubble;

import java.util.Arrays;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/5 20:53
 */
public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 3, 2, 1};

        Bubble.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
