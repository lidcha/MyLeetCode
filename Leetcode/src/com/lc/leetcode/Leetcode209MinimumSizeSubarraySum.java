package com.lc.leetcode;

public class Leetcode209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0)  return 0;
        int resLen = nums.length+1;
        int left = 0, right =0, sum=0;
        while(right<nums.length){
            while(sum<s&&right<nums.length){
                sum+=nums[right++];
            }
            while(sum>=s){
                resLen = Math.min(resLen, right-left);
                sum-=nums[left++];
            }
        }
        return resLen==nums.length+1?0:resLen;
    }

    public static void main(String[] args) {
        int s = 11;
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int res = new Leetcode209MinimumSizeSubarraySum().minSubArrayLen(s, nums);
        System.out.println(res);
    }
}
