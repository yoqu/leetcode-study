package org.yoqu.study;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: yoqu
 * @date: 2019-01-18
 * @email: yoqulin@qq.com
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 **/
public class RepeatingCharacters {

    public static void main(String[] args) {
        int size = new RepeatingCharacters().lengthOfLongestSubstring("abcabc");
        System.out.println(size);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = 1;
        for (int i = 0; i < chars.length; i++) {
            int size = 1;
            Set<Character> set = new HashSet<>();
            set.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (set.contains(chars[j])) {

                    break;
                }
                set.add(chars[j]);
                size++;
            }
            if (size > maxLength) {
                maxLength = size;
            }
        }
        return maxLength;
    }
}
