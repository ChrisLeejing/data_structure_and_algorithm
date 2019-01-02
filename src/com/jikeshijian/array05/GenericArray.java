package com.jikeshijian.array05;

import java.util.Arrays;

/**
 * GenericArray
 * A complete array of kinds of methods.
 *
 * @author lijing
 * @date 2019/1/2 15:30
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    /**
     * initialize the array.
     *
     * @param capacity
     */
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * with the default capacity of 10.
     */
    public GenericArray() {
        this(10);
    }

    /**
     * get the capacity of the array.
     *
     * @return int
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * get the size of the current array.
     *
     * @return int
     */
    public int count() {
        return size;
    }

    /**
     * the array is empty of not.
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * modify the value of the index with e.
     *
     * @param index the index of value.
     * @param e     the new value.
     */
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    /**
     * get the value of the index.
     *
     * @param index the index of value.
     * @return the value.
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * the array contains the value e or not.
     *
     * @param e the value.
     * @return true or false.
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * find the index of e.
     *
     * @param e the value.
     * @return the index.
     */
    public int index(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * add the new value e to the index of array.
     *
     * @param index the location of value.
     * @param e     the new value.
     */
    public void add(int index, T e) {
        checkIndex(index);
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * add a new value to the head of the array.
     *
     * @param e the new value.
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * add a new value to the end of the array.
     *
     * @param e the new value.
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * remove the value of the index.
     *
     * @param index the location of the value.
     * @return the value.
     */
    public T remove(int index) {
        checkIndexForRemove(index);
        T value = data[index];

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return value;
    }

    /**
     * remove the first value of the array.
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * remove the end value of the array.
     */
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * check the index when add a new value.
     *
     * @param index the index of value.
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, required the index >= 0 and index <= size");
        }
    }

    /**
     * remove the value e.
     *
     * @param e the value.
     */
    public void removeElement(T e) {
        int index = index(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * check the index when remove a value.
     *
     * @param index the index of value.
     */
    private void checkIndexForRemove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, required the index >= 0 and index < size");
        }
    }

    /**
     * resize the array: O(n).
     *
     * @param capacity the new size.
     */
    public void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    @Override
    public String toString() {
        return "GenericArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
