package org.yoqu.study;

import java.util.Arrays;

/**
 * @author: yoqu
 * @date: 2019-05-09
 * @email: yoqulin@qq.com
 * 加一  https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 **/
public class PlusArray {

    public static void main(String[] args) {
        int[] nums = new int[]{9,9};
        int[] result = new PlusArray().plusOne(nums);
        System.out.println("结果:" + Arrays.toString(result));

    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if(i==0){
                    int[] resultes= new int[digits.length+1];
                    resultes[0]=1;
                    return resultes;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }
}
