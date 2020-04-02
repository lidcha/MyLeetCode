package moveZeros_283;

/**
 * @description 将数组中的0移动到数组的末尾，不能利用其余的数组，数据结构中有这个题
 * @createDate ：2020年4月2日
 */
public class Solution {
	/*
	 * 解法：此题一般有两种解法，判断非0数字，或者判断0；这里是非零
	 */
	public void moveZeros(int[] nums) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {//判断非零数字
				nums[k++] = nums[i];
			}
		}
		while (k < nums.length)
			nums[k++] = 0;
	}
}
