package org.hyz.problem;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author huyz
 */
public class Solution_3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (StringUtils.isBlank(s)) {
            return 0;
        }
        Set<Character> result = new HashSet<>();
        int length = 0;
        char[] sChar = s.toCharArray();
        int lowIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (result.contains(sChar[i])) {
                while (lowIndex < i && sChar[lowIndex] != sChar[i]) {
                    result.remove(sChar[lowIndex]);
                    lowIndex++;
                }
            } else {
                result.add(sChar[i]);
            }
            length = Math.max(length, result.size());
        }
        return length;
    }
}
