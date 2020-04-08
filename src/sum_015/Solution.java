package sum_015;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @description Given an array nums of n integers, are there elements a, b, c in
 *              nums such that a + b + c = 0? Find all unique triplets in the
 *              array which gives the sum of zero.
 * 
 *              Note:
 * 
 *              The solution set must not contain duplicate triplets.
 * 
 *              Example:
 * 
 *              Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 *              A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * @createDate ：2020年4月8日
 */
public class Solution {
	
	/*
	 * 解法与TwoSum基本一致，先排序，遍历nums中的每个数字，再利用双指针，
	 * 不断去寻找与当前数字组合能得0的两个数字，但此题的目的在于去重
	 */
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])	//去重
				continue;
			if (nums[i] > 0)	//去重
				break;
			int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
			while (left < right) {
				if (nums[left] + nums[right] == sum) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));	//这样添加list很方便
					while (left < right && nums[left] == nums[left + 1])	//去重
						left++;
					while (left < right && nums[right] == nums[right - 1])	//去重
						right--;
					left++;
					right--;
				} else if (nums[left] + nums[right] < sum)
					left++;
				else
					right--;
			}
		}
		return res;
	}

}
