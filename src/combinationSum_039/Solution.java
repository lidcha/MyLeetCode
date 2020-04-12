package combinationSum_039;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

/**
 * @description
 * @createDate ：2020年4月12日
 */
public class Solution {

	/*
	 * 所谓回溯法，需要多看看
	 */
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		helper(candidates, list, target, 0, 0);
		return res;
	}

	public void helper(int[] candiates, List<Integer> list, int target, int sum, int index) {
		if (sum > target)
			return;
		if (sum == target) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = index; i < candiates.length; i++) {
			if (sum + candiates[i] <= target) {
				list.add(candiates[i]);
				helper(candiates, list, target, sum + candiates[i], i);
				list.remove(list.size() - 1);
			} else
				break;
		}
	}
}
