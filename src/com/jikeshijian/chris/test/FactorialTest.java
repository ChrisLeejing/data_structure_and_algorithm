package com.jikeshijian.chris.test;

/**
 * This is description.
 * Recursion function.
 *
 * @author Chris Lee
 * @date 2020/7/22 19:29
 */
public class FactorialTest {
    public static void main(String[] args) {
        long result = factorial(100000);

        /*
        Exception in thread "main" java.lang.StackOverflowError
	at com.jikeshijian.chris.test.FactorialTest.factorial(FactorialTest.java:20)
         */
        System.out.println(result);
    }

    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
