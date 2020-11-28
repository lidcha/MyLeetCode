package com.lc.leetcode;

import java.util.HashMap;

public class Leetcode76MinimuWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.length() > s.length() || s.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (map.containsKey(temp)) {
                int value = map.get(temp);
                value++;
                map.put(temp, value);
            } else {
                map.put(temp, 1);
            }
        }
        System.out.println(map.toString());
        String res = "";
        int cnt = 0, left = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                int value = map.get(temp);
                value--;
                map.put(temp, value);
                if (value >= 0)
                    cnt++;
            }
            while (cnt == t.length()) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
//                    s.su
                    res = s.substring(left, left + minLen);
                }
                char c = s.charAt(left);
                if (map.containsKey(c)) {
                    int value = map.get(c);
                    value++;
                    map.put(c, value);
                    if (value > 0) cnt--;
                }
                ++left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode76MinimuWindowSubstring solution = new Leetcode76MinimuWindowSubstring();
        String res = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }
}
