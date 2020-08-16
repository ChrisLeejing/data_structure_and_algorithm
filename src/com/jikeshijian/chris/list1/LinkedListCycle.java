package com.jikeshijian.chris.list1;

/**
 * This is description.
 * LeetCode 141:
 * <p>
 * - https://leetcode.com/problems/linked-list-cycle/
 * <p>
 * 有环时两个指针一定会相遇的数学证明:
 * <p>
 * - https://zhuanlan.zhihu.com/p/33663488
 *
 * @author Chris0710
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
