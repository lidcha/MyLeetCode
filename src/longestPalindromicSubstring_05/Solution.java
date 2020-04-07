package longestPalindromicSubstring_05;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @description
 * @createDate ：2020年4月7日
 */
public class Solution {
	/*
	 * 动态规划，核心思想：延伸 单个字符必是回文，相邻两个相同字符必是回文 ... ...
	 * 推导下去,某字符序列是否为回文，取决于{首尾字符是否相同，去掉首尾后的字符序列是否为回文}
	 */
	/*
	 * 暴力的话时间复杂度为O(n^3),动态规划时间复杂度为O(n^2)
	 */
	public String longestPalindrome(String str) {
		if (str.length() == 1)
			return str;
		if (str.length() == 0)
			return "";
		int[][] dp = new int[str.length()][str.length()];
		int start = 0;// 标记开始字符
		int length = 1;// 单个字符必是回文，length记录字符长度
		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = 1;
			if (i < str.length() - 1) {
				if (str.charAt(i) == str.charAt(i + 1)) {// 判断相邻字符是否为回文
					dp[i][i + 1] = 1;
					start = i;
					length = 2;
				}
			}
		}
		for (int len = 3; len <= str.length(); len++) {
			for (int i = 0; i + len - 1 < str.length(); i++) {
				int j = i + len - 1;
				if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == 1) {// i-j的字符序列是否为回文，
					// 取决于两个条件
					dp[i][j] = 1;
					start = i;
					length = len;
				}
			}
		}
		return str.substring(start, start + length);
	}

	/*
	 * junit测试	
	 */
	@Test
	public void test() {
		assertEquals("ccc", new Solution().longestPalindrome("ccc"));
	}
}
