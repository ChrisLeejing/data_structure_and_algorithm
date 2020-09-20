package com.jikeshijian.chris.test;

import com.jikeshijian.chris.heap.HeapSort;

import java.util.Arrays;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class HeapSortTest {
    public static void main(String[] args) {
        //to be sorted array.(1A, 2B, 3C, 4D, 5E, 6F, 7G, 8H, 9I, 10J, 11K, 12L, 13M, 14N, 15O, 16P, 17Q, 18R, 19S, 20T, 21U, 22V, 23W, 24X, 25Y, 26Z)
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
