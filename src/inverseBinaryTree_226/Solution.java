package inverseBinaryTree_226;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Stack;

/**
* @description 二叉树反转
* @createDate ：2020年4月1日
*/
/**
 * Definition for a binary tree node.
 * 
 * }
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	/*
	 * 解法：递归用栈代替
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root != null)
			return null;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			TreeNode left = node.left;
			TreeNode right = node.right;
			node.left = right;
			node.right = left;
			if (node.left != null)
				stack.add(node.left);
			if (node.right != null)
				stack.add(node.right);
		}
		return root;
	}
}
