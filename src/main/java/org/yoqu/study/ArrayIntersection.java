package org.yoqu.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yoqu
 * @date: 2019-01-23
 * @email: yoqulin@qq.com
 * 两个数组的交集 II https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 **/
public class ArrayIntersection {

    //[4,9,5]
    //[9,4,9,8,4]
    public static void main(String[] args) {
        //[1,2,2,1]
        //[2]
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2};
        int[] result = new ArrayIntersection().intersect(nums1, nums2);
        System.out.println("计算结果：" + Arrays.toString(result));
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> re = new ArrayList<>();
        List skip = new ArrayList();
        int nums1l = nums1.length;
        int nums2l = nums2.length;
        if (nums1l > nums2l) {
            two:
            for (int i = 0; i < nums2l; i++) {
                for (int j = 0; j < nums1l; j++) {
                    if (nums2[i] == nums1[j]) {
                        if (skip.contains(i)) {
                            continue two;
                        }
                        re.add(nums1[j]);
                        skip.add(i);
                    }
                }
            }
        } else {
            two:
            for (int i = 0; i < nums1l; i++) {
                for (int j = 0; j < nums2l; j++) {
                    if (nums2[j] == nums1[i]) {
                        if (skip.contains(i)) {
                            continue two;
                        }
                        re.add(nums1[i]);
                        skip.add(i);
                    }
                }
            }
        }
        int[] result = new int[re.size()];
        int i = 0;
        for (Integer r : re) {
            result[i++] = r;
        }
        return result;
    }
}
