package cmbinationSumII_040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @createDate ：2020年4月12日
 */
public class Solution {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		helper(candidates, list, target, 0, 0);
		return res;
	}

	public void helper(int[] candidates, List<Integer> list, int target, int sum, int index) {
		if (sum > target || index > candidates.length)
			return;
		if (sum == target) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			helper(candidates, list, target, sum + candidates[i], i + 1); // 不可以形成自环，所以每次都从下一个节点开始搜索，传入下一个节点index
			list.remove(list.size() - 1);
			while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) // 存在重复节点，题目要求不可以重复，于是需要跳过重复节点
				i++;
		}
	}
}