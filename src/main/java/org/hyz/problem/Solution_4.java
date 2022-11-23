package org.hyz.problem;

import java.util.Stack;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 */
public class Solution_4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return (nums2[nums2.length / 2] + nums2[(nums2.length - 1) / 2]) * 1.0 / 2;
        } else if (nums2.length == 0) {
            return (nums1[nums1.length / 2] + nums1[(nums1.length - 1) / 2]) * 1.0 / 2;
        } else {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0, j = 0; stack.size() <= (nums1.length + nums2.length) / 2
                    && (i < nums1.length || j < nums2.length); ) {
                if (i >= nums1.length) {
                    stack.push(nums2[j++]);
                } else if (j >= nums2.length) {
                    stack.push(nums2[i++]);
                } else {
                    if (nums1[i] > nums2[j]) {
                        stack.push(nums2[j++]);
                    } else {
                        stack.push(nums1[i++]);
                    }
                }
            }
            if ((nums1.length + nums2.length) / 2 == (nums1.length + nums2.length - 1) / 2) {
                return stack.pop() * 1.0;
            }
            return (stack.pop() + stack.pop()) * 1.0 / 2;

        }
    }

}
