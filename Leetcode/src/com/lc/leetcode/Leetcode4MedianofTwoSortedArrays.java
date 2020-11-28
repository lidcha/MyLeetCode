package com.lc.leetcode;

import java.text.DecimalFormat;

/**
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class Leetcode4MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] newArray = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                newArray[k] = nums1[i];
                i++;
            } else {
                newArray[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) newArray[k++] = nums1[i++];
        while (j < n) newArray[k++] = nums2[j++];

        DecimalFormat df = new DecimalFormat("0.00000");
        Utils.printArrays(newArray);
        if ((m + n) % 2 == 0) {
            //偶数
            int x1 = newArray[(m + n) / 2];
            System.out.println(x1);
            int x2 = newArray[(m + n) / 2 - 1];
            System.out.println(x2);
            double x = ((double) x1 + (double) x2) / 2;
            String res = df.format(x);
            return new Double(res);
        } else {//奇数
            String s = df.format(newArray[(m + n) / 2]);
            return new Double(s);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double x = new Leetcode4MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(x);
//        double b = 10 / 3.0;
//        DecimalFormat df = new DecimalFormat("0.00000 ");
//        System.out.println(df.format(b));
//        System.out.println(b);
    }
}
