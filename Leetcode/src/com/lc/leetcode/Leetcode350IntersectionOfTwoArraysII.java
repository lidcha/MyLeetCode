package com.lc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode350IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> list = new ArrayList<>();
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;j++;
            }else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
        }

        int[] res = new int[list.size()];
        for(int k=0;k<list.size();k++){
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] res = new Leetcode350IntersectionOfTwoArraysII().intersect(nums1, nums2);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+"\t");
    }
}
