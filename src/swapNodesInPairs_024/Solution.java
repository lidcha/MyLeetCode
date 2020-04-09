package swapNodesInPairs_024;

import static org.hamcrest.CoreMatchers.nullValue;

/**
 * @description
 * @createDate ：2020年4月9日
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
	 * 解法：代码看着极为臃肿，不如看别人大神的
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode p = dummyHead.next;
		ListNode q = p.next;
		ListNode pre = dummyHead;
		while (q != null) {
			pre.next = q;
			p.next = q.next;
			q.next = p;

			pre = p;
			p = pre.next;
			if (p == null || p.next == null)
				q = null;
			else
				q = p.next;
		}
		return dummyHead.next;
	}
	
	/*
	 * 大神版本
	 */
	public ListNode swapPairs_v1(ListNode head){
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		while(pre.next!=null&&pre.next.next!=null){
			ListNode cur = pre.next, suc = cur.next, tmp = suc.next;
			pre.next = suc;
			cur.next = tmp;
			suc.next = cur;
			pre = cur;
		}
		return dummyHead.next;
		
	}
	
}
