package reverseLinkedList_206;

/**
 * Definition for singly-linked list.
 * 
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
	 * 解法：利用头插法，p代表当前节点，不断将p用头插法插入到head之后
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode r = new ListNode(0);
		ListNode p, q;
		r.next = head;
		head = r;

		p = head.next;
		q = p.next;
		head.next = null;
		while (q != null) {
			p.next = head.next;
			head.next = p;
			p = q;
			q = q.next;
		}
		p.next = head.next;
		head.next = p;
		return head.next;
	}
	/*
	 * 题解：使用一个变量记录前驱prev，一个变量记录后继next，不断current.next = prev;
	 */
	 public ListNode reverseList_v1(ListNode head) {
	        ListNode pre = null, cur = head;

	        while (cur != null) {
	            ListNode next = cur.next;
	            cur.next = pre;
	            pre = cur;
	            cur = next;
	        }

	        return pre;
	}
	
	
}