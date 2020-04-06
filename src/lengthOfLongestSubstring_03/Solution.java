package lengthOfLongestSubstring_03;

import static org.junit.Assert.assertEquals;

import java.awt.RenderingHints;
import java.util.HashMap;

import org.junit.Test;

/**
 * @description
 * @createDate ：2020年4月6日
 */
public class Solution {
	
	/*
	 * map的作用是存储未出现过的字符及index，若字符未出现则添加到map中，否则应将窗口左边界缩短为重复字符的下一个位置
	 * 并将重复字符的index也就是map中的value更新
	 */

	public int lengthOfLongestSubstring(String s) {
		int res = 0;//作为结果
		HashMap<Character, Integer> map = new HashMap<>();
		int left = 0, right = 0;// 设置滑动窗口左右边界
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if(map.containsKey(temp)){
				left = Math.max(left, map.get(temp)+1);
				//这里对left做比较，是排除虽然出现了重复字符但重复字符不在当前窗口中的情况
				//例如abba，对于s[3],虽然出现了重复字符a，但是由于map已经过滤掉了之前的重复字符
				//所以应对其处理，而如果用下面语句则会出现错误，使left重新回到1
//				left = map.get(temp)+1;
				right = i+1;
				map.put(temp, i);
			}else{
				right++;
				map.put(temp, i);
			}
			//判断是否需要更新res
			res = Math.max(res, right-left);
		}
		return res;
	}

	/*
	 * junit测试
	 */
	@Test
	public void test() {
		assertEquals(3, new Solution().lengthOfLongestSubstring("abcba"));
	}
}
