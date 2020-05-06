package com.jawadhyder.practice;

import com.jawadhyder.practice.util.Helper;
import com.jawadhyder.practice.util.ListNode;

public class AddTwoNumbersLinkedList {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode<Integer> a3 = new ListNode<>(3, null);
        ListNode<Integer> a2 = new ListNode<>(4, a3);
        ListNode<Integer> a1 = new ListNode<>(2, a2);

        ListNode<Integer> b3 = new ListNode<>(4, null);
        ListNode<Integer> b2 = new ListNode<>(6, b3);
        ListNode<Integer> b1 = new ListNode<>(5, b2);

        Helper.printLinkedList(addTwoNumbers(a1, b1));
    }

    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> result = null;
        ListNode<Integer> next = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int sum = (a + b + carry);
            carry = sum / 10;
            if (result == null) {
                result = new ListNode<>(sum % 10, next);
                next = result;
            } else {
                next.next = new ListNode<>(sum % 10, null);
                next = next.next;
            }
        }

        if (carry > 0) {
            next.next = new ListNode<>( carry, null);;
        }

        return result;
    }
}
