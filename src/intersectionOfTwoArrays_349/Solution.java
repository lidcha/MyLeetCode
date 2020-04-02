package intersectionOfTwoArrays_349;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @description
 * @createDate ：2020年4月2日
 */
public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> intrsection = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i]))
				intrsection.add(nums2[i]);
		}
		int[] res = new int[intrsection.size()];
		int k = 0;
		for (int i : intrsection) {
			res[k++] = i;
		}
		return res;
	}

	/*
	 * junit测试一直报错误，不知道什么原因
	 */
	@Test
	public void test() {
		int[] excepted = new int[] { 9, 4 };
		int[] nums1 = new int[] { 4, 9, 5 }, nums2 = new int[] { 9, 4, 9, 8, 4 };
		assertEquals(excepted, new Solution().intersection(nums1, nums2));
	}

}
