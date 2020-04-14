package nextPermutation_031;

/**
 * @description
 * @createDate ：2020年4月10日
 */
public class Solution {
	public void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;j--;
		}
	}

	public void nextPermutation(int[] nums) {
		int length = nums.length;
		int i = length - 2;
		while (i > -1 && nums[i] >= nums[i + 1])
			i--;
		if (i > -1) {
			int j = length - 1;
			while (nums[j] < nums[i])
				j--;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		reverse(nums, i + 1, length - 1);
	}

	public static void main(String[] args) {
		int[] excepted = new int[] { 1, 3, 2 };
		int[] nums = new int[] { 3, 5, 1, 4, 2 };
		new Solution().nextPermutation(nums);
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}
}
