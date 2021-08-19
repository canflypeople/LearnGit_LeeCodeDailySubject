package com.com.code2021.com.code2021.march;

import com.util.ListNode;

import java.io.File;

/**
 * @program:
 * @description:
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @author: zhongmou.ji
 * @create: 2021/3/18 上午9:20
 **/
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode currNode = dummyNode;
        int index = 1;
        while (index < left) {
            currNode = currNode.next;
            index++;
        }
        ListNode leftNode = currNode;
        currNode = currNode.next;
        ListNode lastNode = currNode;
        // 迭代， 反转链表
        ListNode pre = currNode, curr = currNode.next;
        pre.next = null;
        while (index < right) {
            if (index == right - 1) {

            }
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            index++;
        }
        ListNode preNode = pre;
        ListNode rightNode = curr;
        leftNode.next = preNode;
        lastNode.next = rightNode;
        return dummyNode.next;

    }

    private ListNode[] reverse(ListNode head) {
        ListNode[] ret = new ListNode[2];
        ret[1] = head;
        // 迭代， 反转链表
        ListNode pre = head, curr = head.next;
        pre.next = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        ret[0] = pre;
        return ret;
    }

    public static void main(String[] args) {
        LeetCode92 leetCode92 = new LeetCode92();
        ListNode listNode = leetCode92.reverseBetween(ListNode.getListNode(new int[]{1,2,3,4,5}), 2, 4);
        ListNode.printListNode(listNode);
    }
}
