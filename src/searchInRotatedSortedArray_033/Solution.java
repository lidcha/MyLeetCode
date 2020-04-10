package searchInRotatedSortedArray_033;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.classfile.LocalVariableTable;

import jdk.nashorn.internal.ir.Flags;
import sun.print.resources.serviceui;

/**
 * @description
 * @createDate ：2020年4月10日
 */
public class Solution {
	/*
	 * 复杂度为O(n)
	 */
	public int search(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		int k = -1;
		while (i <= j) {
			if (nums[i] == target) {
				k = i;
				break;
			} else if (nums[j] == target) {
				k = j;
				break;
			}
			i++;
			j--;
		}
		return k;
	}

	/*
	 * 题目要求时间按复杂度为O(log n),则必跟二分查找有关 首先序列按某主元素旋转，两种旋转类型{[6, 7, 0, 1, 2, 3, 4,
	 * 5],[3, 4, 5, 6, 7, 0, 1, 2]}， 即左边有序元素多或者右边有序元素多 当为第一种情况时： 》》mid = 1;
	 * 若target>mid,则target有可能在nums[4]-nums[7],或者在nums[0]-nums[1],于是令left=mid+
	 * 1或者right=mid-1; 若trget<mid 则target在nums[2]-nums[2],令right=mid-1;
	 * 当为第二种情况时： 》》mid = 6; 若target>mid,则在mid右边，令left = mid+1; 若target<mid
	 * 则target有可能在nums[0]-nums[2]或者在nums[5]-nums[7],于是令right=mid-1,或者left=mid+1;
	 * 继续循环
	 */

	public int search_v1(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			// 第一种情况
			if (nums[mid] < nums[left]) {
				if (nums[mid] > target)
					right = mid - 1;
				else {
					if (nums[left] > target)
						left = mid + 1;
					else
						right = mid - 1;
				}
			} else { // 第二种情况
				if (nums[mid] < target)
					left = mid + 1;
				else {
					if (nums[left] > target)
						left = mid + 1;
					else
						right = mid - 1;
				}
			}
		}
		return -1;
	}

	@Test
	public void test() {
		// assertEquals(-1, new Solution().search_v1(new int[] { 6, 7, 0, 1, 2,
		// 3, 4, 5 }, 8));
		assertEquals(7, new Solution().search_v1(new int[] { 3, 4, 5, 6, 7, 0, 1, 2 }, 2));
		assertEquals(2, new Solution().search_v1(new int[] { 5, 1, 3 }, 3));
	}
}
