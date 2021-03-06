package org.yoqu.study;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZero {

    public static void main(String[] args) {
        int nums[] = new int[]{0, 0,1};
        System.out.println(Arrays.toString(nums));
        new MoveZero().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 这个办法效率比较低，但是可以移动任何数
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int found = 0;
        for (int i = 0; i < nums.length; i++) {
            if (found + i == nums.length - 1) {
                break;
            }
            if (nums[i] == 0) {//如果当前数为0
                int num = nums[i];
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = num;
                found++;
                i = -1;
            }
        }
    }


    /**
     * 高效率解决问题
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        for (int i=idx;i<nums.length;i++) {
            nums[i] = 0;
        }
    }
}
