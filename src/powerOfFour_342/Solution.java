package powerOfFour_342;
/**
* @description 判断数字是否是4的幂
* @createDate ：2020年4月2日
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution {
	/*
	 * 常规解法:不断除4，循环
	 */
	public boolean isPowerOfFour(int num) {
		if (num == 0)
			return false;
		while (true) {
			if (num == 1)
				return true;
			if (num % 4 == 0)
				num /= 4;
			else
				return false;
		}
	}
	/*
	 * 解法2：找规律，4的幂的二进制表示有以下两条规律
	 * （1）4的幂只有一个1，其余位都是，例如4^2=16(10000)--->只需保证是2的幂次方，利用n&(n-1)判断
	 * （2）1在最高位，且是在奇数位--->找一个二进制数，奇数位全是1，偶数位全是0，然后两个数相与
	 */
	public boolean isPowerOfFour_v1(int num){
		if(num==0)	return false;
		int specialNum = 0b01010101010101010101010101010101;
		if((num&(num-1))==0&&(num&specialNum)==num)
			return true;
		else
			return false;
			
	}
	
	@Test
	public void test(){
		assertEquals(true, new Solution().isPowerOfFour_v1(16));
	}
}
