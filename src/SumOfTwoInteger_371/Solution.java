package SumOfTwoInteger_371;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @description Calculate the sum of two integers a and b, but you are not
 *              allowed to use the operator + and -.
 * 
 *              Example 1:
 * 
 *              Input: a = 1, b = 2 Output: 3 Example 2:
 * 
 *              Input: a = -2, b = 3 Output: 1
 * @createDate ：2020年4月3日
 */
public class Solution {
	/*
	 * 
	 * 异或：相同位0相异为1；同0异1； AND: 只有同时为1结果才为1；用于判断同时为1，然后左移1位
	 */
	public int sumOfTwoInteger(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;// 当得出正确结果时，纵使b不断左移，a与b相异或，相and结果都等于a;
			// 而且carry会等0；进而b=0；退出循环
		}
		return a;
	}

	/*
	 * 这里第二种解法比较好理解，思想与第一种解法相同
	 */
	public int getSum(int a, int b) {
		if (b == 0)
			return a;// 递归将carry视为b，当carry为0时自然应返回sum

		int sum = a ^ b;// 计算sum without carry
		int carry = a & b;
		carry = carry << 1;// caculate carry
		return getSum(sum, carry);
	}

	@Test
	public void test() {
		assertEquals(5, new Solution().getSum(2, 3));
	}
}
