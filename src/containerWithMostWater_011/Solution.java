package containerWithMostWater_011;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sun.javafx.image.IntPixelAccessor;

/**
 * @description Given n non-negative integers a1, a2, ..., an , where each
 *              represents a point at coordinate (i, ai). n vertical lines are
 *              drawn such that the two endpoints of line i is at (i, ai) and
 *              (i, 0). Find two lines, which together with x-axis forms a
 *              container, such that the container contains the most water.
 * 
 *              Note: You may not slant the container and n is at least 2.
 * @createDate ：2020年4月7日
 */
public class Solution {
	/*
	 * 暴力解法，利用双重for循环
	 */
	public int maxArea(int[] height) {
		int len = height.length;
		if (len == 2)
			return Math.min(height[0], height[1]);
		int res = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				int temp = Math.min(height[i], height[j]) * (j - i);
				if (temp > res)
					res = temp;
			}
		}
		return res;
	}

	/*
	 * 利用双指针，初始left=0，right=len-1,如果[left, right]面积有可能发生变化，则必然是从较短边向里面移动，
	 * 这是因为面积取决于短边 假如从长边移动，即使长边移动后的height非常高，但是面积仍然是短边*长度
	 */
	public int maxArea_v1(int[] height) {
		int res = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int temp = Math.min(height[left], height[right]) * (right - left); // 记录此时left与right之间的面积
			res = Math.max(res, temp);
			if (height[left] <= height[right]) // 移动指针
				left++;
			else
				right--;
		}
		return res;
	}

	@Test
	public void test() {
		assertEquals(49, new Solution().maxArea_v1(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}
}
