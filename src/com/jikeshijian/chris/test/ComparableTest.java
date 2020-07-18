package com.jikeshijian.chris.test;

import com.jikeshijian.chris.sort1.Student;

/**
 * This is description.
 *
 * @author Chris Lee
 * @date 2020/7/5 19:20
 */
public class ComparableTest {
    private static Comparable getMax(Comparable c1, Comparable c2) {
        int com = c1.compareTo(c2);
        if (com >= 0) {
            return c1;
        }
        return c2;
    }

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 14);
        Student s2 = new Student("lisi", 13);

        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }
}
