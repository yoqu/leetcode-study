package org.yoqu.study;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * @author yoqu
 * @date 2018/3/17 - 下午8:04
 * 给定两个非空链表来代表两个非负数，位数按照逆序方式存储，它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        TwoNumberSum solution = new TwoNumberSum();
        ListNode l1 = solution.l1();//solution.generateNode();
        ListNode l2 = solution.l2();//solution.generateNode();
        ListNode node = new TwoNumberSum().addTwoNumbers2(l1, l2);
        System.out.println("l1:" + l1 + "\nl2:" + l2 + "\nl3:" + node);
    }

    public ListNode l1() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(8);
//        listNode.next.next = new ListNode(3);
        return listNode;
    }

    public ListNode l2() {
        ListNode listNode = new ListNode(0);
//        listNode.next = new ListNode(5);
//        listNode.next.next = new ListNode(4);
        return listNode;
    }

    /**
     * 自己写得算法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returnNode = new ListNode(0);
        ListNode l3 = returnNode;
        while (l1 != null && l2 != null) {
            l3.val = l3.val + l1.val + l2.val;
            if (l1.next == null && l2.next == null) {
                if (l3.val > 9) {
                    l3.next = new ListNode(0);
                    l3.val = l3.val - 10;
                    l3.next.val++;
                }
                break;
            }
            l3.next = new ListNode(0);
            if (l3.val > 9) {
                l3.val = l3.val - 10;
                l3.next.val++;
            }
            l3 = l3.next;
            if (l1.next == null && l2.next != null) {
                l1.next = new ListNode(0);
            }

            if (l1.next != null && l2.next == null) {
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return returnNode;
    }

    /**
     * leetcode 解答的算法,
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode l3 = result;
        int cal = 0;
        while (l1 != null || l2 != null || cal != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + cal;
            cal = sum / 10;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return result.next;
    }

    public ListNode generateNode() {
        ListNode listNode = new ListNode(RandomUtils.nextInt(0, 9));
        ListNode retNode = listNode;
        for (int i = 0; i < 2; i++) {
            listNode.next = new ListNode(RandomUtils.nextInt(0, 9));
            listNode = listNode.next;
        }
        return retNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append(val);
            ListNode nextNode = next;
            while (nextNode != null) {
                builder.append(",").
                        append(nextNode.val);
                nextNode = nextNode.next;
            }
            builder.append("]");
            return builder.toString();
        }
    }

}
