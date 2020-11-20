package com.november.week.second;

import com.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeeCode328 {

    public ListNode oddEvenList(ListNode head) {
        // 暴力破解
        List<ListNode> nodes1 = new ArrayList<>();
        List<ListNode> nodes2 = new ArrayList<>();
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        while (dummyNode.next != null) {
            nodes1.add(dummyNode.next);
            dummyNode = dummyNode.next;
            if (dummyNode.next == null) {
                break;
            }
            nodes2.add(dummyNode.next);
            dummyNode = dummyNode.next;
        }
        dummyNode = new ListNode();
        ListNode preNode = dummyNode;
        for (ListNode node : nodes1) {
            dummyNode.next = node;
            dummyNode = dummyNode.next;
        }
        for (ListNode node : nodes2) {
            dummyNode.next = node;
            dummyNode = dummyNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LeeCode328 leeCode328 = new LeeCode328();
        leeCode328.oddEvenList(ListNode.getListNode(new int[]{1,2,3,4,5}));
    }
}
