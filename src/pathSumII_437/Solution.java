package pathSumII_437;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

/**
 * @description You are given a binary tree in which each node contains an
 *              integer value.
 * 
 *              Find the number of paths that sum to a given value.
 * 
 *              The path does not need to start or end at the root or a leaf,
 *              but it must go downwards (traveling only from parent nodes to
 *              child nodes).
 * 
 *              The tree has no more than 1,000 nodes and the values are in the
 *              range -1,000,000 to 1,000,000.
 * 
 *              Example:
 * 
 *              root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 *              10 / \ 5 -3 / \ \ 3 2 11 / \ \ 3 -2 1
 * 
 *              Return 3. The paths that sum to 8 are:
 * 
 *              1. 5 -> 3 2. 5 -> 2 -> 1 3. -3 -> 11
 * @createDate ：2020年4月3日
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	/*
	 * helper方法只能判断当前根节点参与时是否可以形成一条路径，而不能判断其子节点是否还会形成路径，
	 * 事实上，子节点是否会形成路径，是由pathSum方法递归到此子节点，进而判断得出
	 */
	public int helper(TreeNode root, int sum) {
		if (root == null)
			return 0;
		int l = helper(root.left, sum - root.val);
		int r = helper(root.right, sum - root.val);
		return l + r + (root.val == sum ? 1 : 0);
	}

	/*
	 * 递归判断每一个节点是否能形成路径
	 */
	public int pathSumII(TreeNode root, int sum) {
		if (root == null)
			return 0;
		int self = helper(root, sum);
		int l = pathSumII(root.left, sum);
		int r = pathSumII(root.right, sum);
		return self + l + r;

	}
}
