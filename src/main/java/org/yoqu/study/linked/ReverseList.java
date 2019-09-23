package org.yoqu.study.linked;

/**
 * 翻转链表
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode node = new ReverseList().reverseList(listNode);
        System.out.println(node);
    }

    public ListNode reverseList(ListNode head) {
        ListNode tempNode = head;
        ListNode newNode = new ListNode(head.val);
        while ( tempNode.next != null) {
            tempNode = tempNode.next;
            ListNode newNode2 = new ListNode(tempNode.val);
            newNode2.next = newNode;
            newNode = newNode2;
        }
        return newNode;
    }
}
