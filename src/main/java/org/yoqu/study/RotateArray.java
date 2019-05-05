package org.yoqu.study;

import java.util.Arrays;

/**
 * @author: yoqu
 * @date: 2019-01-23
 * @email: yoqulin@qq.com
 * 旋转数组 https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 * <p>
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 **/
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 2;
        System.out.println(String.format("数组:%s,向右移动%s个位置", Arrays.toString(nums), k));
        new RotateArray().rotate2(nums, k);
        System.out.println("处理:" + Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int f = (i + k) % nums.length;
            result[ f] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]= result[i];
        }
    }

    /**
     * 方法2. 跳位计算
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
