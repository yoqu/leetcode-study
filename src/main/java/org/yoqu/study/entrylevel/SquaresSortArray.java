package org.yoqu.study.entrylevel;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class SquaresSortArray {

    public static void main(String[] args) {
        SquaresSortArray array = new SquaresSortArray();
        int[] a = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(array.sortedSquares(a)));
    }

    public int[] sortedSquares(int[] nums) {
        int index = nums.length - 1;
        int left = 0;
        int right = index;
        int[] result = new int[nums.length];
        while (left <= right) {
            int l1 = nums[left] * nums[left];
            int r1 = nums[right] * nums[right];
            if (l1 > r1) {
                result[index--] = l1;
                left += 1;
            } else {
                result[index--] = r1;
                right -= 1;
            }
        }
        return result;
    }
}
