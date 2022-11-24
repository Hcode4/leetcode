package org.hyz.problem;

import org.apache.commons.lang3.StringUtils;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 两种情况，一种奇数， 一种偶数
 *
 * @author huyz
 */
public class Solution_5 {

    public static void main(String[] args) {
        String s = "abaa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String result = "";
        if (StringUtils.isEmpty(s) || s.length() == 1) {
            return result;
        }

        for (int i = 1; i < s.length() - 1; i++) {
            String resultTempFirst = mindRise(s, i - 1, i + 1);
            String resultTempSecond = mindRise(s, i, i + 1);
            boolean resultTempFEmp = StringUtils.isEmpty(resultTempFirst) || resultTempFirst.length() == 1;
            boolean resultTempSEmp = StringUtils.isEmpty(resultTempSecond) || resultTempSecond.length() == 1;
            if (resultTempFEmp && resultTempSEmp) {
                continue;
            }

            result = result.length() > resultTempFirst.length() ? result : resultTempFirst;
            result = result.length() > resultTempSecond.length() ? result : resultTempSecond;
        }
        return result;
    }


    public static String mindRise(String s, int lowIndex, int highIndex) {
        char[] array = s.toCharArray();
        int i = lowIndex;
        int j = highIndex;
        while (i > 0 && j < s.length() - 1) {
            if (array[i] == array[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        if (array[i] != array[j]) {
            i++;
            j--;
        }
        return s.substring(i, j + 1);
    }
}
