package com.november.three;

import com.util.ListNode;

public class LeeCode147 {

    public ListNode insertionSortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public ListNode insertionSortList(ListNode head) {
        // 将数组插入到他左边的元素中
        // 双指针，一个指针指向排序的部分，一个指针指向待排序的部分
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode tempNode = node.next;
            node.next = null;
            head = insert(head, node);
            node = tempNode;
        }
        return head;
    }

    /**
     * 将node节点插入到有序链表中，依旧保持有序
     * @param head
     * @param node
     * @return
     */
    private ListNode insert(ListNode head, ListNode node) {
        if (node.val < head.val) {
            node.next = head;
            return node;
        }
        ListNode preNode = head;
        while (preNode.next != null) {
            if (node.val < preNode.next.val) {
                node.next = preNode.next;
                preNode.next = node;
                break;
            }
            preNode = preNode.next;
        }
        if (preNode.next == null) {
            preNode.next = node;
        }

        return head;
    }

    public static void main(String[] args) {
        LeeCode147 leeCode147 = new LeeCode147();
        ListNode.printListNode(leeCode147.insertionSortList(ListNode.getListNode(new int[]{4,2,1,3})));
    }
}
