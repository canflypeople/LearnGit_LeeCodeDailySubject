package com.util;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode getListNode(int[] nums) {
        ListNode dummyNode = new ListNode();
        ListNode head = new ListNode(nums[0]);
        dummyNode.next = head;
        dummyNode = dummyNode.next;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            dummyNode.next = node;
            dummyNode = dummyNode.next;
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
