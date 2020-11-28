package com.lc.leetcode;

public class Leetcode75SortColors {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        int temp = nums[left];
        while (i < j) {
            while (nums[j] >= temp && i < j) j--;
            while (nums[i] <= temp && i < j) i++;
            if (i < j) {
                int a = nums[i];
                nums[i] = nums[j];
                nums[j] = a;
            }
        }
        //nums[i]要么已经被交换，要么一直小于基准数，故nums[i]<temp;(always)
        //故可将nums[i]放心与nums[left]交换
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }
    private static String arrayToString(int[] arr) {
        String str = "";
        for(int a : arr) {
            str += a + "\t";
        }
        return str;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        Leetcode75SortColors solution = new Leetcode75SortColors();
        solution.sortColors(nums);
        String str = Leetcode75SortColors.arrayToString(nums);
        System.out.println(str);
    }
}
