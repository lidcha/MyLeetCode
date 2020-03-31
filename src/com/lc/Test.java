package com.lc;

import java.util.Arrays;

import com.sun.javafx.collections.SortableList;

/**
 * @author
 * @createDate ：2020年3月27日
 */
public class Test {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] newNums = { 0, 0, 0, 0, 0 };
		newNums = Arrays.copyOf(nums, nums.length);
		for (int i : newNums) {
			System.out.println(i);
		}
	}
}
