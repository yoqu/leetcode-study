package org.yoqu.study.entrylevel;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 * 通过次数544,768提交次数1,179,925
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @status: finish
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7};
        int target = 5;
        System.out.println(new SearchInsert().searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        do {
            int m = (right - left) / 2 + left;
            if (target > nums[m]) {
                left = m + 1;
            } else if (target < nums[m]) {
                right = m - 1;
            } else {
                return m;
            }
        } while (left <= right);
        return left;
    }
}
