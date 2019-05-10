package org.yoqu.study;

import java.util.*;

/**
 * @author yoqu
 * @date 2018/5/8
 * <p>
 * 只出现一次的数字  https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class OnlyOneNum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 0, 1};
//        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(String.format("数组: %s", Arrays.toString(nums)));
        int sum = new OnlyOneNum().singleNumber2(nums);
        System.out.println("计算结果：" + sum);
    }


    public int singleNumber(int[] nums) {
        List oneList = new LinkedList();
        Set<Integer> strings = new HashSet<>();
        Set<Integer> delNum = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (strings.add(nums[i])) {
                oneList.add(nums[i]);
            } else {
                delNum.add(nums[i]);
            }
        }
        oneList.removeAll(delNum);
        return (int) oneList.get(0);
    }

    /**
     * 通过异或运算符相同为为0，不同位为1来找出不重复的数
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

}
