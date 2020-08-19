package com.jikeshijian.chris.list1;

/**
 * This is description.
 * Maths: f(n, m) = (f(n-1, m) + m) % n, f(1, m) = 0.
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 链接：
 * 1. https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 2. https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/si-chong-fang-fa-xiang-xi-jie-da-by-yuanninesuns/
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * @author Chris0710
 */
public class JosephusProblem {
    public static void main(String[] args) {
        int lastRemainingIterator = lastRemainingIterator(5, 3);
        System.out.println(lastRemainingIterator);
        int lastRemainingRecursion = lastRemainingRecursion(10, 17);
        System.out.println(lastRemainingRecursion);
    }

    public static int lastRemainingIterator(int n, int m) {
        // flag = f(n, m) = f(i, m)
        int flag = 0;

        for (int i = 1; i <= n; i++) {
            // f(n, m) = (f(n-1, m) + m) % n.
            flag = (flag + m) % i;
        }
        return flag;
    }

    public static int lastRemainingRecursion(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (lastRemainingRecursion(n - 1, m) + m) % n;
    }
}
