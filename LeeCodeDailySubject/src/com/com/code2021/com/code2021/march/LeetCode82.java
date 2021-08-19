package com.com.code2021.com.code2021.march;

import com.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program:
 * @description:
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * @author: zhongmou.ji
 * @create: 2021/3/25 上午9:11
 **/
public class LeetCode82 {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummyNode = new ListNode(Integer.MAX_VALUE, head);
    ListNode preNode = dummyNode;
    while (head != null) {
      int currValue = head.val;
      if (head.next == null) {
        break;
      } else if (head.next != null && head.val != head.next.val) {
        preNode = head;
        head = head.next;
      } else {
        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }
        head = head.next;
        preNode.next = head;
      }
    }
    return dummyNode.next;
  }

  public static void main(String[] args) {
    LeetCode82 leetCode82 = new LeetCode82();
    leetCode82.deleteDuplicates(ListNode.getListNode(new int[]{1,2,3,3,4,4,5}));
  }
}
