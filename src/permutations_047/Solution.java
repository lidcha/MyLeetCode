package permutations_047;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.sun.javafx.image.IntPixelAccessor;

/**
 * @description Given a collection of numbers that might contain duplicates,
 *              return all possible unique permutations.
 * 
 *              Example:
 * 
 *              Input: [//] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 * @createDate ：2020年4月14日
 */
public class Solution {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<Integer> list = new ArrayList<>();
		helper(nums, list);
		return res;
	}

	public void helper(int[] nums, List<Integer> list) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(list.contains(nums[i])) continue;
			list.add(nums[i]);
			helper(nums, list);
			list.remove(list.size() - 1);
		}
	}

	@Test
	public void test() {
		int[] nums = new int[] { 1, 1, 2 };
		List<List<Integer>> expected = new ArrayList<>();
		expected.add(Arrays.asList(1, 1, 2));
		expected.add(Arrays.asList(1, 2, 1));
		expected.add(Arrays.asList(2, 1, 1));
		assertEquals(expected, new Solution().permuteUnique(nums));
	}
}
