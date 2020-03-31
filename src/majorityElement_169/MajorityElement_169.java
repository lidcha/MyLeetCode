package majorityElement_169;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * @author
 * @createDate ：2020年3月30日
 */
public class MajorityElement_169 {
	/*
	 * 解法一：先排序然后记录
	 */
	public int majorityElement(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		Arrays.sort(nums);
		int cnt = 1;
		int k = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == k) {
				cnt++;
			} else {
				if (cnt > nums.length / 2) {
					break;
				}
				cnt = 1;
				k = nums[i];
			}
		}
		return k;
	}
	
	/*
	 * 解法二：投票法
	 */
	public int  majorityElement_v1(int[] nums) {
		int cnt = 1;
		int res = nums[0];
		for(int i=1;i<nums.length;i++){
			if(nums[i]==res){
				cnt++;
			}else{
				cnt--;
				if(cnt==0){
					res = nums[i];
					cnt=1;
				}
			}
		}
		return res;
	}
	
	/*
	 * 本题还有很多种其他的解法，例如bit-manipulation法(没搞懂)，分治法等等
	 */
	@Test
	public void test() {
		assertEquals(2, new MajorityElement_169().majorityElement_v1(new int[] { 2,2,1,1,1,2,2 }));
	}
}
