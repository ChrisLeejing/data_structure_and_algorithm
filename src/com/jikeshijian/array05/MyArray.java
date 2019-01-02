package com.jikeshijian.array05;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * Define the int array data structure.
 *
 * @author lijing
 * @date 2019/1/2 11:21
 */
public class MyArray {
    public static void main(String[] args) {
        MyArray array = new MyArray(10);
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        System.out.println(Arrays.toString(array.data));

        array.insert(4, 7);

        System.out.println(Arrays.toString(array.data));

        array.delete(2);

        System.out.println(Arrays.toString(array.data));

        int value = array.find(4);
        System.out.println("the index 4 of the value is: " + value);

        array.replace(5, 9);
        System.out.println(Arrays.toString(array.data));

        array.add(5);
        array.add(6);
        array.add(6);
        array.add(6);
        array.add(6);
        array.add(6);
    }

    /**
     * store the data of int array.
     */
    public int[] data;

    /**
     * the length of int array.
     */
    private int n;

    /**
     * the real number of int array.
     */
    private int count;

    /**
     * initial the int array.
     *
     * @param capacity the initial number of the array.
     */
    public MyArray(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * add value to the end of the array.
     *
     * @param value a new value.
     * @return true or false.
     */
    public boolean add(int value) {
        if (count >= n) {
            // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 10
            throw new ArrayIndexOutOfBoundsException(count);
        }

        data[count] = value;
        count++;

        return true;
    }
    /**
     * insert a value into the array.
     *
     * @param index the index location of new value.
     * @param value the new value.
     * @return true or false.
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > count) {
            return false;
        }

        // move the index of value to the next with index in [index, count - 1].
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        count++;

        return true;
    }

    /**
     * delete the element of array through the index of array.
     * @param index the location of the element.
     * @return true or false.
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }

        // move the index of value to the pre-index with index in [index, count - 1].
        for (int i = index; i < count; i++) {
            data[i] = data[i + 1];
        }

        count--;

        return true;
    }

    /**
     * find the value of the index of array.
     * @param index the location of the value.
     * @return the value.
     */
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }

        return data[index];
    }

    /**
     * replace the index of value with a new value.
     *
     * @param index the location of the value.
     * @param value the new value.
     * @return true or false.
     */
    public boolean replace(int index, int value) {
        if (index < 0 || index >= count) {
            return false;
        }
        data[index] = value;

        return true;
    }
}
