package MaximumDepthofBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import sun.reflect.generics.tree.Tree;

/**
 * @author
 * @createDate ：2020年3月27日
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class DepthOfBinaryTree {
	//层次遍历实现求二叉树的深度
	public int maxDepth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		int count=0,depth=0,nextCount=1;//count记录当前层的节点数
					//		，nextCount记录当前层最右边的节点,初始值为1，即第一层共一个节点
		queue.offer(root);//根节点入队列
		while(!queue.isEmpty()){
			TreeNode tmpNode = queue.poll();//出队列
			count++;
			if(tmpNode.left!=null)
				queue.offer(tmpNode.left);//左孩子不空，入队列
			if(tmpNode.right!=null)
				queue.offer(tmpNode.right);//右孩子不空，入队列
			if(count==nextCount){//当前层节点已遍历完，都已出队列
				nextCount=queue.size();//当前队列中自然都是下一层的节点
				count = 0;//重新计数
				depth++;//深度加一
			}
		}
		return depth;
	}

	public static int maxDepth_v1(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		int depth = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {//此处有疑问，不懂
				TreeNode tmpNode = queue.poll();
				if (tmpNode.left != null)
					queue.offer(tmpNode.left);
				if (tmpNode.right != null)
					queue.offer(tmpNode.right);
			}
			depth++;
		}
		return depth;
	}

	
}
