package addTwoNumbers_02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sun.corba.se.impl.orbutil.graph.Node;

/**
 * @description :You are given two non-empty linked lists representing two
 *              non-negative integers. The digits are stored in reverse order
 *              and each of their nodes contain a single digit. Add the two
 *              numbers and return it as a linked list.
 * 
 *              You may assume the two numbers do not contain any leading zero,
 *              except the number 0 itself.
 * 
 *              Example:
 * 
 *              Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *              Explanation: 342 + 465 = 807.
 * @createDate ：2020年4月5日
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
	 * 解法重点：主要是对进位时的处理，包括后面仍有数字的进位处理和无数字的进位处理
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode r1 = l1;
		ListNode r2 = l2;
		ListNode res = l1;
		ListNode head = new ListNode(0);
		int carry = 0;
		while (r1 != null || r2 != null) {
			int val1 = r1 == null ? 0 : r1.val;
			int val2 = r2 == null ? 0 : r2.val;
			int sum = val1 + val2;
			ListNode node = new ListNode(sum % 10);
			carry = sum / 10;
			res.next = node;
			res = node;
			if (r1 != null)
				r1 = r1.next;
			if (r2 != null)
				r2 = r2.next;
		}
		if (carry != 0)
			res.next = new ListNode(carry);
		return head.next;
	}

	public ListNode getList(int[] nums) {
		ListNode root = new ListNode(0);
		root.next = null;
		ListNode pListNode = root;
		for (int i = 0; i < nums.length; i++) {
			ListNode node = new ListNode(nums[i]);
			pListNode.next = node;
			pListNode = node;
		}
		return root.next;
	}

	@Test
	public void test() {
		ListNode l1 = getList(new int[] { 2, 4, 3 });
		ListNode l2 = getList(new int[] { 5, 6, 4 });
		ListNode expected = getList(new int[] { 7, 0, 8 });
		assertEquals(expected, new Solution().addTwoNumbers(l1, l2));
	}

}
