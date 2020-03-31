package reverseBits_190;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author
 * @createDate ：2020年3月30日
 */
public class ReverseBits_190 {
	// you need treat n as an unsigned value
	/*
	 * 题解：利用位运算，共32位，从个位开始，不断将res左移，并且加上n的个位，再将n右移一位，有了新的个位
	 * 其中n&1=1代表n的个位是1，n&1=0代表n的个位是0；
	 */
	public int reverseBits(int n) {
		int res = 0;
		for(int i=0;i<32;i++){
			res = (res<<1)+(n&1);
			n=n>>1;
		}
		return res;
	}

	@Test
	public void test() {
		assertEquals(964176192, new ReverseBits_190().reverseBits(43261596));
	}
}
