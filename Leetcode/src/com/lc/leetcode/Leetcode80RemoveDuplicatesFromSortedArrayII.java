package com.lc.leetcode;

public class Leetcode80RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int cntForNum = 1;
        int i = 0;
        for (int j = i + 1; j < nums.length;) {
            if (nums[j] == nums[i] && cntForNum == 0) {
                j++;
            } else {
                if (nums[j] == nums[i]) cntForNum--;
                else
                    cntForNum = 1;
                nums[++i] = nums[j++];
            }
        }
        return nums.length == 0 ? 0 :(i + 1);
    }

    public static void main(String[] args) {
        int length = new Leetcode80RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        System.out.println(length);
    }
}
