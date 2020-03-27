package MaximumSubarray_53;

/**
 * @description：leetcode problem 53.Maximum Subarray
 * @createDate ：2020年3月26日
 */
public class MaxSumArraySolution {

	// 暴力求解,时间复杂度O(n^3);
	public static int maxSumArray_v0(int[] nums) {
		if(nums.length==1)  return nums[0];
		int SUM = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {// 枚举所有的子序列
				int sumTmp = 0;
				for (int k = i; k <= j; k++)// 求单个子序列的和
					sumTmp += nums[k];
				if (sumTmp > SUM)
					SUM = sumTmp;
			}
		}
		return SUM;
	}

	// 利用前缀和求解，S[i]=a[1]+...+a[i],则从i到j的序列和为S[j]-S[i-1];
	public static int MaxSumArray_v1(int[] nums) {
		if(nums.length==1)  return nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++)// 求前缀和，在nums数组上直接求
			nums[i] = nums[i] + nums[i - 1];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int tmp = 0;
				if (i == 0)//判断i指针的位置，否则会数组溢出
					tmp = nums[j] - 0;
				else
					tmp = nums[j] - nums[i - 1];
				if (tmp > sum)
					sum = tmp;
			}
		}
		return sum;
	}
//	分治法，利用递归，中间元素分界线，左边最大子序列和，右边最大子序列和，比较
	public static int MaxSumArray_v2(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		return helper(nums, 0, nums.length - 1);
	}

	public static int helper(int[] nums, int l, int r) {
		if (l > r)
			return Integer.MIN_VALUE;
		// int mid = (l+r)>>>1;
		int mid = (l + r) / 2;
		int left = helper(nums, l, mid - 1);
		int right = helper(nums, mid + 1, r);
		
		//求左边最大子序列和
		int leftMaxSum = 0;
		int sum = 0;//记录子序列和
		for (int i = mid - 1; i >= l; i--) {//求某子序列和
			sum += nums[i];//即使序列中出现负数，导致和变小，但sum仍会记录
			leftMaxSum = Math.max(sum, leftMaxSum);//由leftMaxSum记录出现的最大子序列和
		}
		//求右边最大子序列和
		int rightMaxSum = 0;
		sum = 0;
		for (int i = mid + 1; i <= r; i++) {
			sum += nums[i];
			rightMaxSum = Math.max(sum, rightMaxSum);
		}
		//比较三种情况{左，右，左+中+右}的最大值返回；
		return Math.max(nums[mid] + leftMaxSum + rightMaxSum, Math.max(left, right));
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3 };
		int sum = MaxSumArraySolution.MaxSumArray_v2(nums);
		System.out.println(sum);

	}
}
