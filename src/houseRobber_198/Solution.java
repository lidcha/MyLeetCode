package houseRobber_198;
/**
* @description 
* @createDate ：2020年3月31日
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution {
	
	/*
	 * 题解：本题是一道简单的动态规划问题，第i个房子是否能抢取决于max（i=i-1时抢的钱，i=i-2时抢的钱+第i个房子的钱）;
	 * 举例：[1, 3, 4, 5, 3, 2],dp数组为存放经过房子抢的钱
	 * dp[0]=1,dp[1]=3,于是dp[2]=max{dp[1], dp[0]+nums[2]},即dp[2]=5;
	 * dp[3]=max{dp[2], dp[1]+nums[3]}
	 * ...
	 * dp[5]=max{dp[4], dp[3]+nums[4]}
	 */
	public int rob(int[] nums) {
        if(nums.length==0)	return 0;
        if(nums.length==1)	return nums[0];
        if(nums.length==2)	return Math.max(nums[1], nums[0]);
		int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        int i;
        for(i=2;i<nums.length;i++){
        	dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[i-1];
    }
	
	@Test
	public void test(){
		assertEquals(10, new Solution().rob(new int[]{1, 3, 4, 5, 3, 2}));
	}
}
