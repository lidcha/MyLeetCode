package RemoveNthNodeFromEndofList_019;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @description Given a linked list, remove the n-th node from the end of list
 *              and return its head.
 * 
 *              Example:
 * 
 *              Given linked list: 1->2->3->4->5, and n = 2.
 * 
 *              After removing the second node from the end, the linked list
 *              becomes 1->2->3->5. Note:
 * 
 *              Given n will always be valid.
 * @createDate ：2020年4月8日
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {

	/*
	 * 解法：利用双指针，q先走n步，此时p与q相距length-n；然后p，q同时走，
	 * 当q走到为空，p走到length-n前一个位置，正好为倒数n个节点的前驱节点 note：给链表新增头节点后，则应走n+1步
	 */
	public ListNode removeNthFromEnd_v1(ListNode head, int n) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode p = dummyHead;
		ListNode q = dummyHead;
		for (int i = 0; i <= n; i++) { // 增加了头节点，应走n+1步
			if (q.next == null) // 判断q是否走到末尾
				q = null;
			else
				q = q.next;
		}
		while (q != null) {
			q = q.next;
			p = p.next;
		}
		p.next = p.next.next;
		return dummyHead.next;
	}
}
