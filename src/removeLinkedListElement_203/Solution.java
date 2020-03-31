package removeLinkedListElement_203;

/**
* @description RemoveLinkedListElement_203
* @createDate ：2020年3月31日
*/
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
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
	 * 题解：利用q作为当前节点的前节点，p作为当前节点，为方便操作，给链表加一个头节点
	 */
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode node = new ListNode(0);
		node.next = head;
		head = node;
		ListNode p = head.next, q = head;

		while (p != null) {
			if (p.val == val) {
				q.next = p.next;
				p = q.next;
			} else {
				q = p;
				p = p.next;
			}
		}
		return head.next;
	}
}
