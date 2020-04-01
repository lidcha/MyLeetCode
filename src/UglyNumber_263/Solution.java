package UglyNumber_263;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @description:丑数（2，3，5）
 * @createDate ：2020年4月1日
 */
public class Solution {
	public boolean isUgly(int num) {
		if(num<=0)	return false;
		
		while(true){
			if(num==1||num==2||num==3||num==5)
				return true;
			if(num%2==0)
				num/=2;
			else if(num%3==0)
				num/=3;
			else if (num%5==0)
				num/=5;
			else {
				return false;
			}
		}
	}
	@Test
	public void test(){
		assertEquals(true, new Solution().isUgly(6));
	}
}
