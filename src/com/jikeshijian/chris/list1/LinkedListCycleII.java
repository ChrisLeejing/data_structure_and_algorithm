package com.jikeshijian.chris.list1;

/**
 * This is description.
 * LeetCode 142:
 * <p>
 * - https://leetcode.com/problems/linked-list-cycle-ii/
 * <p>
 * 求环的入口数学证明:
 * <p>
 * - https://zhuanlan.zhihu.com/p/33663488
 *
 * @author Chris0710
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode tmp = head;
                while (tmp != slow) {
                    tmp = tmp.next;
                    slow = slow.next;
                }
                return tmp;
            }
        }

        return null;
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
