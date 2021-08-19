package com.com.code2021.com.code2021.march;

import com.util.ListNode;
import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @author: zhongmou.ji
 * @create: 2021/3/27 下午9:52
 **/
public class LeetCode61 {

  public ListNode rotateRight(ListNode head, int k) {
    // 计算链表的长度
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    int len = 0;
    ListNode dummyNode = new ListNode(0, head);
    ListNode lastNode = new ListNode();
    while (head != null) {
      len++;
      if (head.next == null) {
        lastNode = head;
      }
      head = head.next;
    }
    int offSet = k % len;
    ListNode curr = dummyNode;
    while (offSet >= 1) {
      curr = curr.next;
      offSet--;
    }
    ListNode ret = curr.next;
    curr.next = null;
    lastNode.next = dummyNode.next;
    return ret;
    // 指针操作
  }

  public static void main(String[] args) {
    LeetCode61 leetCode61 = new LeetCode61();
    ListNode.printListNode(leetCode61.rotateRight(ListNode.getListNode(new int[]{1, 2}), 1));
    ListNode.printListNode(leetCode61.rotateRight(ListNode.getListNode(new int[]{1, 2, 3, 4, 5}), 2));
  }

  class BSTIterator {
    private int curr;
    private List<Integer> list;

    public BSTIterator(TreeNode root) {
      list = new ArrayList<>();
      curr = 0;
      if (root == null) {
        return;
      }
      midOrder(root);
    }

    private void midOrder(TreeNode root) {
      if (root.left != null) {
        midOrder(root.left);
      }
      list.add(root.val);
      if (root.right != null) {
        midOrder(root.right);
      }
    }

    public int next() {
      return list.get(curr++);
    }

    public boolean hasNext() {
      return curr < list.size();
    }
  }
}
