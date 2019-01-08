package com.jikeshijian.linkedlist06;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUBasedArray
 * LRU(Least Recently Use) Cache.
 * 1. Space complexity: O(n)
 * 2. Time complexity: O(n)
 * 3. do not support null cache.
 * @author lijing
 * @date 2019/1/3 15:44
 */
public class LRUBasedArray<T> {
    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.value = (T[])new Object[capacity];
        this.holder = new HashMap<>(capacity);
    }

    /**
     * Simulate access object of the array.
     * @param object access object.
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("This cache container does not support 'null' value.");
        }

        Integer index = holder.get(object);

        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * If the array contains the object, then update the object.
     * @param index the new object.
     */
    private void update(int index) {
        T target = value[index];
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * Remove the last element and cache the object to the head of the array.
     * @param object the new object.
     */
    private void removeAndCache(T object) {
        value[--count] = null;
        cache(object, count);
    }

    /**
     * Move every element to the next index and cache the object.
     * @param object the new object.
     * @param end the number of array.
     */
    private void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * Move every element to the next index.
     * @param end the
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    /**
     * Judge the array is full or not.
     * @return true or false.
     */
    public boolean isFull() {
        return count == capacity;
    }

    public static void main(String[] args){
        /*
            0000 0001
            0000 1000
         */
        System.out.println(1 << 3);

    }


}
