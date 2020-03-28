package singleNumber_136;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import sun.java2d.loops.XORComposite;

/**
 * @author
 * @createDate ：2020年3月28日
 */
public class SingleNumber_136 {
	// 先排序，然后去寻找single Number，但是此解法不符合题意
	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int single = Integer.MIN_VALUE;// 1,1,2,2,4
		for (int i = 0; i < nums.length - 1; i++)
			if (nums[i] != nums[i + 1]) {
				single = nums[i];
				break;
			} else {
				i++;
			}
		if (single == Integer.MIN_VALUE)
			return nums[nums.length - 1];
		else
			return single;
	}

	/** 利用异或的原理，异或：按位比较，相同为0，不同为1。任何数与0的异或均为其本身，原因是任何数化成二进制，
	 *	由0和1组成，0^0=0,0^1=1;(0与0或者1的异或都为其本身)。
	 *	另外，x^y^y=x;经过两次异或一定会回到其本身。此题就是利用这个性质。
	 */ 
	public static int singleNumber_v1(int[] nums) {
		int ret = 0;
		for (int i = 0; i < nums.length; i++) {
			ret = ret ^ nums[i];
		}
		return ret;
	}
	/**
	 * 测试异或
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public int xor(int x, int y, int z) {
		return x ^ y ^ z ^ y ^ z;
	}

	@Test
	public void xorTest() {
		assertEquals(4, new SingleNumber_136().xor(4, 2, 1));
	}

	@Test
	public void singleNumberTest() {
		int[] nums = { 4, 1, 2, 1, 2 };
		assertEquals(4, new SingleNumber_136().singleNumber(nums));
	}

}
