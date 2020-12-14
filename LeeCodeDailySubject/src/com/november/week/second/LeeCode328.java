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

    public ListNode oddEvenList1(ListNode head) {
        // 暴力破解
        List<ListNode> oddNodes = new ArrayList<>();
        List<ListNode> evenNodes = new ArrayList<>();
        ListNode dummyNode = head;
        while (dummyNode != null) {
            oddNodes.add(dummyNode);
            dummyNode = dummyNode.next;
            if (dummyNode != null) {
                evenNodes.add(dummyNode);
                dummyNode = dummyNode.next;
            }
        }
        ListNode preNode = new ListNode();
        dummyNode = preNode.next;
        for (ListNode node : oddNodes) {
            dummyNode.next = node;
            dummyNode = dummyNode.next;
        }
        for (ListNode node : evenNodes) {
            dummyNode.next = node;
            dummyNode = dummyNode.next;
        }
        return dummyNode.next.next;
    }

    public static void main(String[] args) {
        LeeCode328 leeCode328 = new LeeCode328();
        leeCode328.oddEvenList(ListNode.getListNode(new int[]{1,2,3,4,5}));
    }
}
