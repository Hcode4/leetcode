package org.hyz.problem.array;

import org.hyz.problem.common.SolutionSort;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 */
public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int [] nums = {3,2,4};
        int target = 6;
        int [] result = solution_1.getLocationIndex(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        return getLocationIndex(nums, target);
    }

    /**
     * 通过Map 存储数据对应的位置，但是可能存在相同的元素，Map<Integer, List<Integer>
     * 然后讲数组从大到小排序
     * 双指针，首尾进行指针移动
     * 如果小，移动左指针，如果大 移动右指针
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] getLocationIndex(int[] nums, int target) {

        Map<Integer, List<Integer>> localMap = getLocationMap(nums);

        SolutionSort.bubbleSort(nums);
        int[] result = new int[2];

        int lowIndex = 0;
        int highIndex = nums.length - 1;

        while (lowIndex < highIndex) {
            int targetResult = nums[lowIndex] + nums[highIndex];
            if (targetResult > target) {
                highIndex--;
            } else if (targetResult < target) {
                lowIndex++;
            } else {
                int lowValue = nums[lowIndex];
                int highValue = nums[highIndex];
                if (lowValue == highValue) {
                    result[0] = localMap.get(lowValue).get(0);
                    result[1] = localMap.get(lowValue).get(1);
                } else {
                    result[0] = localMap.get(lowValue).get(0);
                    result[1] = localMap.get(highValue).get(0);
                }
                break;
            }
        }
        return result;
    }

    private Map<Integer, List<Integer>> getLocationMap(int[] nums) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = result.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            result.put(nums[i], list);
        }
        return result;
    }
}
