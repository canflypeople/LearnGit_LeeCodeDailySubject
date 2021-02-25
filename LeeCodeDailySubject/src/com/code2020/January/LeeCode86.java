package com.code2020.January;

import com.util.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class LeeCode86 {
    public ListNode partition(ListNode head, int x) {
        List<ListNode> lefts = new LinkedList<>();
        List<ListNode> rights = new LinkedList<>();
        ListNode dummyNode = head;
        while (dummyNode != null) {
            if (dummyNode.val < x) {
                lefts.add(dummyNode);
            } else {
                rights.add(dummyNode);
            }
            ListNode tempNode = dummyNode.next;
            dummyNode.next = null;
            dummyNode = tempNode;
        }
        ListNode preNode = new ListNode();
        dummyNode = preNode;
        for (ListNode node : lefts) {
            preNode.next = node;
            preNode = preNode.next;
        }
        for (ListNode node : rights) {
            preNode.next = node;
            preNode = preNode.next;
        }
        return dummyNode.next;
    }
}
