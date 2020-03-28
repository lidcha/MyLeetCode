package MergedSortArray;

import java.util.Arrays;

import com.sun.scenario.effect.Merge;

/**
 * @author
 * @createDate ：2020年3月27日
 */
public class MergedSortArraySolution {
	public static void merge_v0(int[] nums1, int m, int[] nums2, int n) {
		int[] tmp = Arrays.copyOf(nums1, nums1.length);
		int i = 0, j = 0, k = 0;
		// int[] res = new int[nums1.length];
		while (i < m && j < n) {
			if (tmp[i] >= nums2[j]) {
				nums1[k++] = nums2[j++];
			} else {
				nums1[k++] = tmp[i++];
			}
		}
		while (i < m) {
			nums1[k++] = tmp[i++];
		}
		while (j < n)
			nums1[k++] = nums2[j++];
	}
//	v1相比于v0占用空间会大大减小
	public static void merge_v1(int[] nums1,int m, int[] nums2,int n){
		int i=m-1,j=n-1,k=nums1.length-1;
		while(j>=0){
			if(i>=0&&nums1[i]>nums2[j])
				nums1[k--]=nums1[i--];
			else
				nums1[k--]=nums2[j--];
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = {0,0}, nums2 = {4};
		int m = 1, n = 1;
		MergedSortArraySolution.merge_v1(nums1, m, nums2, n);
		for (int num : nums1) {
			System.out.print(num + " ");
		}
	}
}
