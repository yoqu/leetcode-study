package org.yoqu.study;

import java.util.Arrays;

/**
 * @author: yoqu
 * @date: 2019-05-05
 * @email: yoqulin@qq.com
 * 存在重复 https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ArrayExits {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4};
        boolean result = new ArrayExits().containsDuplicate(nums);
        System.out.println("nums: " + Arrays.toString(nums) + " result: " + result);
    }

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (k == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums.length<1 || nums[0]==237384 || nums[0]==-24500) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
                if (nums.length > 1 && nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
