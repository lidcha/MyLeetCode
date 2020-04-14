package TwoSumII_167;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

import com.sun.javafx.image.IntPixelAccessor;

/**
 * @author
 * @createDate ：2020年3月29日
 */
public class TwoSumII_167 {
	/*
	 * 解法一：题目给出数组已排序，若未排序，则可以先排序， 利用双指针，若左右相加大于target，则右移，小于target则左移，相等则返回
	 */
	public int[] twoSum(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;
		int[] res = new int[2];
		while (i < j) {
			int tmp = numbers[i] + numbers[j];
			if (tmp < target)
				i++;
			else if (tmp > target)
				j--;
			else {
				res[0] = i;
				res[1] = j;
				break;
			}
		}
		return res;
	}

	/*
	 * 解法二：题目未对空间复杂度作要求，可以利用hashmap或数组记录已访问过的数字
	 */
	public int[] twoSum_v1(int[] numbers, int target) {
		int i, index, key = 0;// i作为指针遍历，也作为一个index，index作为另一个index；
		HashMap<Integer, Integer> map = new HashMap<>();
		// 将数组元素放入hashmap中，element作为key，index作为value
		for (int k = 0; k < numbers.length; k++)
			map.put(numbers[k], k);

		for (i = 0; i < numbers.length; i++) {
			int element = numbers[i];
			key = target - element;
			// 利用map的containsKey(),看map是否包含这个数
			if (map.containsKey(key)) {
				break;
			}
		}
		int index1 = map.get(key);
		if (index1 > i)
			return new int[] { i + 1, index1 + 1 };
		else
			return new int[] { index1 + 1, i + 1 };
		// return null;
	}
	/*
	 * 解法三：在解法一的基础上优化，在指针移动时，并不是一步一步的移动，
	 * 而是结合二分查找(binary search)，寻找最佳的位置
	 */
	
	
	@Test
	public void test() {
		int[] excepted = { 1, 2 }, numbers = { 2, 7, 11, 15 };
		int target = 9;
		assertEquals(excepted, new TwoSumII_167().twoSum_v1(numbers, target));
	}

}
