package com.lc.leetcode;


public class Leetcode141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { //只要fast不为null，自然slow不会为null，
            slow = slow.next;
            fast = fast.next.next;  //虽然fast.next.next有可能会为null，但是即使为null，仅仅是fast=null，只会退出循环而已
            if (slow == fast) return true;
        }
        return false;
    }
}
