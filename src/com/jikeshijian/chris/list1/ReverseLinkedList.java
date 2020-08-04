package com.jikeshijian.chris.list1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * This is description.
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author Chris Lee
 * @date 2020/8/4 19:21
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode head = one;
        LinkedList<Integer> before = new LinkedList<>();
        while (head != null) {
            before.add(head.val);
            head = head.next;
        }
        System.out.println(Arrays.toString(before.toArray()));

        ReverseLinkedList rll = new ReverseLinkedList();
        // ListNode result = rll.reverseListRecursive(one);
        ListNode result = rll.reverseListIterative(one);

        LinkedList<Integer> after = new LinkedList<>();
        while (result != null) {
            after.add(result.val);
            result = result.next;
        }
        System.out.println(Arrays.toString(after.toArray()));
    }

    /**
     * Definition for singly-linked list.
     */
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public ListNode reverseListIterative(ListNode head) {
         ListNode prev = null;
         ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;

            // move the pointer to next node.
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
