package numbersOf1Bits_191;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
* @author 
* @createDate ：2020年3月31日
*/
public class Solution {
	/*
	 * 解法：仍然利用位运算，判断n的最后一位是否为1，然后将n右移，重复至左边第一位
	 */
	public int hammingWeight(int n) {
        int cnt = 0;
        for(int i=0;i<32;i++){
            if((n&1)==1) cnt++;
            n=n>>>1;
        }
        return cnt;
    }
	/*
	 * n&(n-1)可以用来消除n的最右边的1,如果最后一位是1，n-1最后一位是0；1&0=0;
	 * 如果最后一位是0，则不断向前借位，知道借到1，自然消除一个1
	 */
	public int hammingWeight_v1(int n){
		int cnt = 0;
		while(n!=0){
			n = n&(n-1);
			cnt++;
		}
		return cnt;
	}
	
	@Test
	public void test(){
		assertEquals(3, new Solution().hammingWeight(11));
	}
}
