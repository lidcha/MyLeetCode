package permutations_046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.javafx.image.IntPixelAccessor;
import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @description Given a collection of distinct integers, return all possible
 *              permutations.
 * 
 *              Example:
 * 
 *              Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1],
 *              [3,1,2], [3,2,1] ]
 * @createDate ：2020年4月13日
 */
public class Solution {
	List<List<Integer>> res = new ArrayList<>(); // 用于结果返回

	public List<List<Integer>> permute(int[] nums) {
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		helper(nums, list);
		return res;
	}

	// 用于回溯的方法
	public void helper(int[] nums, List<Integer> list) {
		if (list.size() > nums.length)
			return;
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i]))
				continue;
			list.add(nums[i]);
			helper(nums, list);
			list.remove(list.size() - 1);
		}

	}
	@Test
	public void test() {
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(1, 2, 3));
		expected.add(Arrays.asList(1, 3, 2));
		expected.add(Arrays.asList(2, 1, 3));
		expected.add(Arrays.asList(2, 3, 1));
		expected.add(Arrays.asList(3, 1, 2));
		expected.add(Arrays.asList(3, 2, 1));
		assertEquals(expected, new permutations_046.Solution().permute(nums));
	}
}
