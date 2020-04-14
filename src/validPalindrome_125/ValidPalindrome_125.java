package validPalindrome_125;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.sun.org.apache.regexp.internal.recompile;

import jdk.nashorn.internal.ir.Flags;
import junitTest.ValidPalindromeTest;

/**
 * @author
 * @createDate ：2020年3月28日
 */
public class ValidPalindrome_125 {

	public static boolean isPalindrome_v1(String s) {
		/*
		 * replaceAll方法返回的是替换下来的值，源字符串并不变，而是一个新字符串
		 */
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String rev = new StringBuffer(actual).reverse().toString();
		return actual.equals(rev);
	}

	public static boolean isValid(Character c) {
		if (c == null)
			return false;
		boolean isNum = Character.isDigit(c);
		boolean isAlpha = Character.isLetter(c);
		return isNum || isAlpha;
	}

	public static boolean isPalindrome(String s) {
		if (s == null)
			return true;
		s = s.toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			Character charLeft = s.charAt(i);
			Character charRight = s.charAt(j);
			if (!isValid(charLeft)) {
				i++;
				// continue;
			} else if (!isValid(charRight)) {
				j--;
				// continue;
			} else {
				if (charLeft != charRight)
					return false;
				i++;
				j--;
			}
		}
		return true;
	}

	@Test
	public void testIsPalindrome_v1() {
		assertEquals(true, new ValidPalindrome_125().isPalindrome_v1("A man, a plan, a canal: Panama"));
	}
}
