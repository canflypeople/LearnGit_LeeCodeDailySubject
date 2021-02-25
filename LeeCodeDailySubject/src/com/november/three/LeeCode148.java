package com.november.three;

import com.util.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeeCode148 {

    /**
     * 归并排序
     * 时间复杂度为O(nlogn)一般都是使用分治法
     * 算法：
     * 1。 将链表一分为二，使用快慢指针获取链表的中点
     * 2。 然后对分离的链表进行归并排序
     * 3。 最后合并两个有序链表
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
        /*if (head == null || head.next == null) {
            return head;
        }
        // 1. 链表一分为二
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNode = slow.next;
        slow.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(midNode);
        ListNode preNode = new ListNode();
        ListNode dummyNode = new ListNode();
        dummyNode.next = preNode;
        // 合并两个有序链表
        while (node1 != null || node2 != null) {
            if (node1.val > node2.val) {
                preNode.next = node2;
                node2 = node2.next;
            } else {
                preNode.next = node1;
                node1 = node1.next;
            }
            preNode = preNode.next;
        }
        if (node1 != null) {
            preNode.next = node1;
        }
        if (node2 != null) {
            preNode.next = node2;
        }
        return dummyNode.next.next;*/
    }



    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }


    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        LeeCode148 leeCode148 = new LeeCode148();
        ListNode.printListNode(leeCode148.sortList(ListNode.getListNode(new int[]{4,2,1,3})));
    }
}
