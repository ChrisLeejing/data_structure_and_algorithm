package com.jikeshijian.chris.list1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * This is description.
 * 876. Middle of the Linked List
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * @author Chris Lee
 * @date 2020/8/3 19:41
 */
public class MiddleLinkedList {
    public static void main(String[] args) {
        MiddleLinkedList middleLinkedList = new MiddleLinkedList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        // five.next = six;

        ListNode head = one;

        middleLinkedList.middleNode(head);
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int middleVal;
        ListNode middleNode;
        LinkedList<Integer> ans = new LinkedList<>();

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        middleVal = slow.val;
        middleNode = slow;
        while (slow != null) {
            ans.add(slow.val);
            slow = slow.next;
        }

        System.out.println("Node " + middleVal + " from this list (Serialization: " + Arrays.toString(ans.toArray()) + ")");
        return middleNode;
    }
}
