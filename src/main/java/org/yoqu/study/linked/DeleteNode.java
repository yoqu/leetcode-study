package org.yoqu.study.linked;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(1);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
//        ListNode node = new DeleteNode().removeElements(listNode4, 1);
//        System.out.println(node);
//        System.out.println(new DeleteNode().countPrimes(10));
        System.out.println(new DeleteNode().smallestGoodBase2("676"));
    }

    public void deleteNode(ListNode node) {
        node = node.next;
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * 给定的 n 保证是有效的。
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode topHead = new ListNode(0);
        topHead.next = head;
        int l = 0;
        while (head != null) {
            head = head.next;
            l++;
        }
        head = topHead;
        l -= n;
        while (l > 0) {
            l--;
            head = head.next;
        }
        head.next = head.next.next;
        return topHead.next;
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode top = new ListNode(0);
        ListNode headNode = new ListNode(0);
        top.next = head;
        headNode.next = top;
        while (top != null) {
            if (top.next != null && top.next.val == val) {
                top.next = top.next.next;
                continue;
            }
            top = top.next;
        }
        return headNode.next.next;
    }

    /**
     * 统计所有小于非负整数 n 的质数的数量。
     * <p>
     * 示例:
     * <p>
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        } else if (n == 3) {
            return 1;
        }
        int primeCount = 1;
        for (int i = 3; i < n; i = i + 2) {
            boolean isPrime = true;
            if (i != 3 && i % 3 == 0) {
                continue;
            } else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.println(i);
                primeCount++;
            }
        }
        return primeCount;
    }

    /**
     * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
     * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
     *
     * @param n
     * @return
     */
    public String smallestGoodBase(String n) {
        Long num = Long.valueOf(n);
        for (int i = 2; i < num; i++) {
            long sum = (long) Math.pow(i, 0);
            for (int j = 1; sum <= num; j++) {
                if (sum == num) {
                    return String.valueOf(i);
                }
                sum += Math.pow(i, j);
            }
        }
        return null;
    }

    public String smallestGoodBase2(String n) {
        Long num = Long.valueOf(n);
        Long x = 2l;
        for (int i = 2; i < Long.valueOf(n); i++) {
            if (num % i == 1) {
                boolean isFound = true;
                while (num == 1) {
                    if (num % i != 1 || num < 1) {
                        isFound = false;
                    }
                    num = num / i;
                }
                if (isFound) {
                    return x.toString();
                }
                continue;
            } else {
                num = Long.valueOf(n);
            }
        }
        return x.toString();
    }
}
