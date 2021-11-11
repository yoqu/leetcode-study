package org.yoqu.study.entrylevel;

/**
 * @link https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteEndNode {
    public static void main(String[] args) {
        ListNode node = build();
        printNode(node);
        ListNode result = new DeleteEndNode().removeNthFromEnd(node, 1);
        printNode(result);
    }

    private static void printNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("");
    }

    private static ListNode build() {
        ListNode node = new ListNode();
        node.val = 1;
        ListNode node2 = new ListNode();
        node2.val = 2;
        node.next = node2;
//        ListNode node3 = new ListNode();
//        node3.val = 3;
//        node2.next = node3;
//        ListNode node4 = new ListNode();
//        node4.val = 4;
//        node3.next = node4;
//        ListNode node5 = new ListNode();
//        node5.val = 5;
//        node4.next = node5;
        return node;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode();
        first.next = head;
        int length = 0;
        ListNode loop = first;
        while ((loop = loop.next) != null) {
            length++;
        }
        int sort = length - n;
        loop = first;
        for (int i = 0; i <= sort; i++) {
            if (i == sort) {
                if (loop.next != null) {
                    loop.next = loop.next.next;
                } else {
                    loop.next = null;
                }
            }
            loop = loop.next;
        }
        return first.next;
    }
}
