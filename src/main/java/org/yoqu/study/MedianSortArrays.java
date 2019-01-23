package org.yoqu.study;

import java.util.Arrays;

/**
 * @author: yoqu
 * @date: 2019-01-22
 * @email: yoqulin@qq.com
 * 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 **/
public class MedianSortArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2};
        int[] nums2 = new int[]{1, 3, 4};
        double value = new MedianSortArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(String.format("数组1: %s数组2: %s", Arrays.toString(nums1), Arrays.toString(nums2)));
        System.out.println("计算结果：" + value);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean jishu = (nums1.length + nums2.length) % 2 == 1;
        if (jishu) {
            int n = ((nums1.length + nums2.length + 1) / 2) - 1;
            return findNumber(nums1, nums2, n);
        } else {
            int n1 = (nums1.length + nums2.length) / 2 - 1;
            int n2 = (nums1.length + nums2.length) / 2;
            int num1 = findNumber(nums1, nums2, n1);
            int num2 = findNumber(nums1, nums2, n2);
            return (num1 + num2) / 2.0;
        }
    }

    public int findNumber(int[] nums1, int[] nums2, int n) {
        int lockNum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = lockNum2; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    break;
                } else {
                    if (i + lockNum2 == n) {//找到中位数
                        return nums2[lockNum2];
                    }
                    lockNum2++;
                }
            }
            if (i + lockNum2 == n) {//找到中位数
                return nums1[i];
            }
        }
        return nums2[(n - nums1.length)];
    }
}
